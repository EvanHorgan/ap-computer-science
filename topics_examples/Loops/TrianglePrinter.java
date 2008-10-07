import java.util.Scanner;

public class TrianglePrinter
{
     public static void main ( String args[])
     {
          Scanner in = new Scanner (System.in);
          
          int sideLength = 0;
          
          System.out.println ("Please enter a length for the side of the triangle: ");
          sideLength = in.nextInt ();
          
          //outer loop controls the number of rows
          for (int i = 0; i < sideLength; i++)
          {
               for (int j = 0; j <= i; j++)
               {
                    System.out.print ("[]");    
               }//end of inner loop
               System.out.println ();
          }//end of outer loop
          
          for (int i = sideLength; i > 0; i--)
          {
               for (int j = 0; j <= i; j++)
               {
                    System.out.print ("[]");    
               }//end of inner loop
               System.out.println ();
          }//end of outer loop
     }//end of main
}//end of class