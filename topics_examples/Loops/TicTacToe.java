//***
//*Evan Horgan
     //*Date: 10/7/08
import java.util.Scanner;

public class TicTacToe
{
     public static void main (String args [])
     {
          final int SIDE_LENGTH = 3;
               Scanner in = new Scanner (System.in);
               
               String [][] board = new String [SIDE_LENGTH][SIDE_LENGTH];
               
               //A nested loop will allow us to loop through the coordinates
               // of the two-dimensional array.
               
               //outer loop will loop through the rows
               for (int row = 0; row <SIDE_LENGTH; row++)
               {
                    for (int col = 0; col < SIDE_LENGTH; col++)
                    {
                         System.out.println ("Entry for (" + row + "," + col + "):");
                         
                         board [row][col] = in.nextLine();
                    }//end inner for
               }//end outer for
               
               System.out.println ("Here is the resulting board:\n\n");
               
               //outer loop will loop through the rows
               for (int row = 0; row <SIDE_LENGTH; row++)
               {
                    for (int col = 0; col < SIDE_LENGTH; col++)
                    {
                         System.out.println (board[row][col] + "");
                         
                         
                      
                    }//end inner for
               }//end outer for
     }
}
               
               
     
     