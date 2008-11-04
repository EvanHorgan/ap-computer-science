/**
 * Evan Horgan
 * 11/3/08
 * An example of passing arrays through methods
 * 
 */

public class ArrayMethods
{
     
     public static void main (String [] args)
     {
          int a = 5;
          
          int [] evens = {2,4,6,8,10,12,14,16,18,20};
          
          /*
           * int [] evens = new int [10]
           * for(int i = 1; i <= 10; i++)
           * {
           *        events [i -1] = i * 2;
           * }
           */
          System.out.print ("BEFORE:\na" + a + "\n{" + evens[0]);
          for ( int i = 0; i < evens.length; i++)
               System.out.print ("," + evens[i]);
          
 
     }//end main
     
     public static void doubleNums (int b, int values[])
     {
          b *=2;
          
          for ( int i = 0; i < values.length; i++)
          {
               values[i] *= 2;
               
          }//end doubleNums method
          
     }//end class
          
               
               