public class Monopoly
{
     public static void main(String [] args)
     {
          Die die = new Die(20);
          
          System.out.println("You rolled a: " + die.nextRoll() + 
          " on a " + die.getNumSides() + " sided die. " + die);
          
          
     }//end main
}//end class
     