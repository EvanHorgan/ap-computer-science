//Evan Horgan
//11/15/08
//help from matts repository


import java.util.Scanner;
 
public class SudokuTester
{
     public static void main (String args [])
     {
          Sudoku board = new Sudoku();
          Scanner in = new Scanner(System.in);
          
          int row;
          int column;
          int input;
          
          System.out.println ("Welcome to Sudoku");
          
          System.out.println(board.toString());
          
          while (true)
          {
               do //checks for valid input
               {
                    System.out.println (" Enter in a Row ");
                    row = in.nextInt();
                    System.out.println ("Enter a Column ");
                    column = in.nextInt();
                    System.out.println ("Enter a number for the Row " + row + " and Column " + column + "\n");
                    input = in.nextInt();
               }while (row > 9 || row < 1 ||
                       column > 9 || column < 1 ||
                       input > 9 || input < 1);
                              
               if (!board.setNumber(row, column, input))
                    System.out.println ("Does not compute");
               
               System.out.println(board.toString());
          }// end while
          
     }//end main
}//end class
 