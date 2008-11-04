public class Numbers 
{
     public static void main (String[] args)
     {
          System.out.println(mult3Sum(0 , 10));
     }
     
     public static int mult3Sum (int a, int b)
     {
          int sum = 0;
          
          for (int i = a; i <= b; i++)
          {
               if ((i % 3) == 0)
          
               sum += i;
                    
          }
          
          return sum;
     }
}
     
