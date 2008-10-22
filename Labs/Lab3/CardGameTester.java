//Evan Horgan
//Help from moodle

public class CardGameTester
{
   public static void main(String[] args)
   {      
      System.out.println(new CardGame("4S").getDescription());
      System.out.println("Your card is the: Four of Spades");  
      System.out.println(new CardGame("QC").getDescription());
      System.out.println("Your card is the: Queen of Clubs");  
      System.out.println(new CardGame("AD").getDescription());
      System.out.println("Your card is the: Ace of Diamonds");  
      System.out.println(new CardGame("10S").getDescription());
      System.out.println("Your card is the: Ten of Spades");  
      System.out.println(new CardGame("CA").getDescription());
      System.out.println("Your card is the: Unknown");  
      System.out.println(new CardGame("").getDescription());
      System.out.println("Your card is the: Unknown");  
      System.out.println(new CardGame("?").getDescription());
      System.out.println("Your card is the: Unknown");  
   }
}