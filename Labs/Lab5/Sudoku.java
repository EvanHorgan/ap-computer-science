//Evan Horgan
//11/15/08
//help from matts repository

public class Sudoku
{
     private int [][] board;
     private static final int ROWS = 9;
     private static final int COLUMNS = 9;
     
     /**
* Creates an empty board
*/
     public Sudoku ()
     {
          board = new int[ROWS][COLUMNS];
     }//end constructor
     
    
     public boolean setNumber (int r, int c, int n)
     {
          boolean isValid = true;
          
          if (board[r - 1][c - 1] != 0) 
                isValid = false;
          
          
          for (int i = 0; i < ROWS; i++)
          {
               if (board[i][c - 1] == n) 
                    isValid = false;
          }
          
          
          for (int i = 0; i < COLUMNS; i++)
          {
               if (board[r - 1][i] == n) 
                    isValid = false;
          }
          
          
          if (isValid)
               board[r - 1][c - 1] = n;
          
          return isValid;
     }//end set method
     
     
     public String toString()
     {
          String boardOutput = "\n|-------|-------|-------|";
          for (int i = 0; i < ROWS; i++)
          {
               boardOutput += "\n| ";
               for (int j = 0; j < COLUMNS; j++)
               {
                    if (board[i][j] == 0)
                         boardOutput += " ";
                    else
                         boardOutput += board[i][j];
                    
                    if ((j + 1) % 3 == 0)
                         boardOutput += " | ";
                    else
                         boardOutput += " ";
               }
               if ((i + 1) % 3 == 0)
                    boardOutput += "\n|-------|-------|-------|";
          }
          boardOutput += "\n\n";
          
          return boardOutput;
     }//end toString method
}//end Sudoku class