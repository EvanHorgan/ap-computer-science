/**
 * This class simulates a pair of n-sided dice.
 * The values when rolling are randomly determined.
 * 
 * @author Mr. Kevin Dietzler
 */
import java.util.*;

public class Die
{
   private int numSides;
   private Random roller;
   
   
   /**
    * This constructor sets a default value for
    * numSides and iinitializes the random object.
    */
   Die ()
   {
      roller = new Random ();
      numSides = 0;
   }//end default constructor
   
   
   /**
    * This constructor sets an initial value for
    * numSides and iinitializes the random object.
    */
   Die (int n)
   {
      roller = new Random ();
      numSides=n;
   }
   
   
   /**
    * This method returns the number of sides the Die has.
    * 
    * @return returns the number of sides.
    */
   public int getNumSides()
   {
      return numSides;
   }
   
   
   /**
    * This method sets the number of sides a Die has.
    * 
    * @param n the new number of sides
    */
   public void setNumSides(int n)
   {
      numSides = n;
   }
   
   
   /**
    * This method returns a random roll.
    * 
    * @return returns a random int from 1 to numSides  .
    */
   public int nextRoll()
   {
      return roller.nextInt(numSides) + 1;
   }
}

