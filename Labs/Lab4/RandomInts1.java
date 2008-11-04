//Evan Horgan


import java.util.Random;

public class RandomInts1
{
     public static void main (String args[])
     {
          Random gen = new Random ();
          
          int nums[] = new int [20];
          
          for (int i =0; i < 20; i++)//stores ints
          {
               int random = gen.nextInt(100) + 1;
               nums[i] = random;
          }
          
         
          for (int i = 0; i<20; i++)
          {
               System.out.println(nums[i]);
          }
     }
}
          
          



