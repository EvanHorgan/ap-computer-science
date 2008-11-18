/*
 * Name: Mr. Dietzler
 * Date: 11/11/08
 * 
 * Description: Test the scope of different types of variables
 */

public class ScopeChecker
{
     public static int globalVariable = 20;
     
     public static void main (String args [])
     {
          int mainVariable = 5;
          int globalVariable = 40;
          
          if (true)
          {
               int ifVariable = 10;
               //int globalVariable = 80; CAN'T BE USED AGAIN INSIDE THE METHOD
               System.out.println ("mainVariable = " + mainVariable);
               System.out.println ("globalVariable in if = " + globalVariable);
          }//end if
          
          // System.out.println ("ifVariable = " + ifVariable); NO LONGER AVAILABLE
          System.out.println ("globalVariable in main = " + globalVariable);
          
          for (int i = 0; i < args.length; i++)
          {
               System.out.println ("args[" + i + "] = " + args[i]);
          }
          
          otherMethod (160, 320);
     }//end main
     
     
     public static void otherMethod (int parameter1, int parameter2)
     {
          System.out.println ("globalVariable in otherMethod = " + globalVariable);
          //System.out.println ("mainVariable in otherMethod = " + mainVariable);
          System.out.println ("parameter1 in otherMethod = " + parameter1);
          System.out.println ("parameter2 in otherMethod = " + parameter2);
     }//end otherMethod

}//end ScopeChecker class