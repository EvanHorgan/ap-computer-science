//Evan Horgan


import java.util.Random;

public class RandomInts2
{
     public static void main (String args[])
     {
          Random gen = new Random ();
          
          int nums[] = new int [20];
          
          boolean isDuplicate;
          int random = 0;
          
          for (int i = 0; i < 20; i++)
          {
               isDuplicate = true;
                    while ( isDuplicate)
               {
                    isDuplicate = false;
                    random = gen.nextInt(100) + 1;
                         
                         for (int j =0; j< 20; j++)
                    {
                         if (random == nums [j])
                              isDuplicate = true;
                    }
                    
               }
               
               nums[i] = random;
               
          }
          
          for (int i = 0; i <10; i++)
          {
               System.out.println(nums[i]);
               
          }
     }
}
                         