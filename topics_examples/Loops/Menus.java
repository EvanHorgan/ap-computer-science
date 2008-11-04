
  // Evan Horgan
  //10/7/08
  //decription simple user menu

import java.util.Scanner;

public class Menus
{
     public static void main (String args [])
     {
          int choice = 0;
          Scanner in =new Scanner(System.in);
          
          do
          {
               System.out.println ("Enter 1 to continue and 2 to quit:");
               choice = in.nextInt ();
               
               switch (choice)
               {
                    case 1:
                         System.out.println ("Continuing...");
                         break;
                    case 2:
                         System.out.println ("Quitting...");
                         break;
                    default:
                         System.out.println ("Invaliid input. Please re-enter");
                         break;
               }//end switch
               
          }//end do
          while (choice 1==2);
          
     }//end main
     
}//end class
                    
 