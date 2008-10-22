//Evan Horgan
// with help from matt's repository


import java.util.Random;
import java.util.Scanner;
 
public class GuessingGame
     
{
     public static void main (String args [])
     {
          int randomNumber;
          
          Random gen = new Random ();
          Scanner in = new Scanner (System.in);
          
          int guess;
          
          randomNumber = gen.nextInt (50) + 1;
          
          System.out.println ("Welcome to \"The Gussing Game !!!!\"");
          System.out.println ("\n\nThe random number has been chosen!");
          
          do
          {
               System.out.print ("\n\nPlease pick a number from 1 to 50:");
               guess = in.nextInt();
               
               if (guess > randomNumber)
                    System.out.println ("Too High! pick a lower number!");
               else if (guess < randomNumber)
                    System.out.println ("Too Low! pick a higher number!");
               else
               {
                    System.out.println ("Correct!");
                    System.out.println ("The number was..." + randomNumber);
               }
          }
          while (guess != randomNumber);
     }
}