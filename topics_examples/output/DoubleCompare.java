/**
 * Description: Show how to proper;y compare two doubles
 */

public class DoubleCompare
{
     public static void main (String args[])
     {
          final double EPSILON = 1E-14;
          double root= Math.sqrt (2);
          double result = root * root - 2;
               
               if (Math.abs (result - 0) <= EPSILON)
                    System.out.printle ("sqrt(2) squared minus 2 is 0");
               else
                    System.out.println ("sqrt(2) squared minus 2 is not 0" +
                                        "but" + result);
     }
}
          