public class DanglingElse
{
     public static void main (String args[])
     {
          int a = 2, b = 12;
          
          if (a > 0)
               if (b < 10)
                    if (b > 5)
                        b = 5;
               else
                    b = 15;
          else
               b = 25;
          
          System.out.println ("b is " + b);
     }
}

