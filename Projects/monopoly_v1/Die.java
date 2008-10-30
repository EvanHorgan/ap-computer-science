import java.util.Random;

/**
 * paragraph descibing object and how to use it/ what it can be used for
 * 
 * @ author name here
 */
public class Die
{
     private int numSides;
     private Random gen;
     
     /**
      * creates new die with a specified number of sides
      * 
      * @param n the number of sides of the die 
      */
     public Die(int n)
     {
          numSides = n;
          gen  = new Random();
     }
     
     /**
      * Descibe method
      * 
      * @return (what it returns)
      */
     public int getNumSides()
     {
          return numSides;
     }
     
     /**
      * Descibe method
      * 
      * @param n (what is n)
      */
     public void setNumSides(int n)
     {
          numSides = n;
     }
     
     /**
      * 
      * 
      */
     public int nextRoll()
     {
          return gen.nextInt(numSides) + 1;
     }
     
     public String toString()
     {
          return "numSides = " + numSides;
     }
     
     
}