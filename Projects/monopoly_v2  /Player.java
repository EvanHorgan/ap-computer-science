/**
 * This class is used to create a player in the game Monopoly.
 * <p>
 * This version of the Player object stores basic information
 * about the player including name, current space, money, how
 * many doubles the player rolled.
 * 
 * @author Mr. Kevin Dietzler
 */

import java.util.*;

public class Player
{
   private String name;
   private int position, money, doubles, whichPiece, outOfJailAttempts;
   private boolean inJail;
   
   /**
    * This constructor sets a default value for
    * name and whichPiece.
    */
   public Player ()
   {
      name = new String ("Anonymous");
      whichPiece = 0;
      position = 0;
      money = 1500;
      doubles = 0;
      inJail = false;
      outOfJailAttempts = 0;
   }//end default constructor
   
   
   /**
    * This constructor sets the value for
    * name and whichPiece.
    * 
    * @param n the player's name
    * @param p the index of the player's piece to be used
    * with the Token class.
    */
   public Player (String n, int p)
   {
      name = new String (n);
      whichPiece = p;
      position = 0;
      money = 1500;
      doubles = 0;
      inJail = false;
      outOfJailAttempts = 0;
   }//end constructor
   
   
   /**
    * Returns the player's name.
    * 
    * @return the player's name
    */
   public String getName ()
   {
      return name;
   }//end getName method
   
   
   /**
    * Resets the player's name.
    * 
    * @param n the player's new name
    */
   public void setName (String n)
   {
      name = n;
   }//end setName method
   
   
   /**
    * Returns the player's piece.
    * 
    * @return the player's piece
    */
   public int getPiece ()
   {
      return whichPiece;
   }//end getPiece method
   
   
   /**
    * Changes the player's piece.
    * 
    * @param p the player's new piece
    */
   public void changePiece (int p)
   {
      whichPiece = p;
   }//end setPiece method
   
   
   /**
    * Returns the player's position.
    * 
    * @return the player's position
    */
   public int getPosition ()
   {
      return position;
   }//end getPosition method
   
   
   /**
    * Moves the player's position after a roll of
    * the dice.  This method returns true if the player
    * passed or landed on GO (space 0) after moving and
    * returns false otherwise.
    * 
    * @param amount the number of spaces to move
    * the position.
    * @return true if the player landed on or passed
    * GO and false if not.
    */
   public boolean movePiece (int amount)
   {
      position += amount;
      if (position >= Monopoly.NUM_SPACES)
      {
         setPosition (position %= 40);
         if (position != 0) setMoney (Monopoly.vars.getGoAmount());
         else setMoney (2*Monopoly.vars.getGoAmount());//player recieves double bonus
                                              //for landing on GO
         return true;
      }
      else return false;
   }//end movePiece method
   
   
   /**
    * Sets the player's position when the game
    * dictates a movement to a specific space.
    * 
    * @param whichSpace the space to move to.
    */
   public void setPosition (int whichSpace)
   {
      position = whichSpace;
   }//end setPosition method
   
   
   /**
    * Returns the player's money.
    * 
    * @return the player's money
    */
   public int getMoney ()
   {
      return money;
   }//end getMoney method
   
   
   /**
    * Adds or subtracts money from a player.  If the
    * parameter is positive, money is added, and if
    * the parameter is negative, money is removed.
    * 
    * @param amount the amount of money to add or remove
    */
   public void setMoney (int amount)
   {
      money += amount;
   }//end setMoney method
   
   
   /**
    * Returns the player's doubles status.  Possible
    * values are 0 - 3.
    * 
    * @return the player's doubles status.
    */
   public int getDoubles ()
   {
      return doubles;
   }//end getDoubles method
   
   
   /**
    * Increments the player's doubles status by 1 and then
    * checks if the player has reached three doubles rolls.
    * If so, then the resetDoubles and changeJailStatus methods
    * are called, and the method returns true.  Else it returns
    * false meaning that less than three doubles have been rolled.
    * 
    * @return true if double have been rolled three times and false
    * if otherwise.
    */
   public boolean addDoubles ()
   {
      doubles ++;
      if (getDoubles () == 3)
      {
         resetDoubles ();
         setPosition (10);
         changeJailStatus ();
         return true;
      }//end if
      else
         return false;
   }//end addDoubles method
   
   
   /**
    * Resets the player's doubles status to 0.
    */
   public void resetDoubles ()
   {
      doubles = 0;
   }//end resetDoubles method
   
   
   /**
    * Returns the player's jail status.
    * 
    * @return the player's jail status.
    */
   public boolean isInJail ()
   {
      return inJail;
   }//end isInJail method
   
   
   /**
    * Reverts the player's jail status to its
    * opposite state.
    */
   public void changeJailStatus ()
   {
      inJail = !inJail;
   }//end changeJailStatus method
   
   
   /**
    * Returns the number of times the player has attempted
    * to roll doubles and get out of jail.
    * 
    * @return the number of times the player has attempted
    * to roll doubles and get out of jail.
    */
   public int getOutOfJailAttempts ()
   {
      return outOfJailAttempts;
   }//end getOutOfJailAttempts method
   
   
   /**
    * Increments the number of times the player has attempted
    * to roll doubles and get out of jail.  Returns true if the
    * player has reached the maximum amount of attempts and resets
    * the count to 0 and false if otherwise.
    * 
    * @return returns true if the player has reached the maximum
    * amount of attempts and false if otherwise.
    */
   public boolean addOutOfJailAttempt ()
   {
      outOfJailAttempts ++;
      if (outOfJailAttempts == Monopoly.MAX_OUT_OF_JAIL_ATTEMPTS)
      {
         resetOutOfJailAttempts ();
         return true;
      }
      else
         return false;
   }//end addOutOfJailAttempt method
   
   
   /**
    * Resets the number of times the player has attempted
    * to roll doubles and get out of jail to 0.
    */
   public void resetOutOfJailAttempts ()
   {
      outOfJailAttempts = 0;
   }//end resetOutOfJailAttempts method
   
   
   /**
    * Returns a printable version of the player's attribute status.
    * <p>
    * To get a printable game status for the player, use the method
    * getGameStatus.
    * 
    * @return a printable version of the player's attrubute status.
    */
   public String toString ()
   {
      return new String (getClass().getName() +
                         "[name=" + getName() + "]" + 
                         "[whichPiece=" + getPiece() + "]" +
                         "[position=" + getPosition() + "]" +
                         "[money=" + getMoney() + "]" +
                         "[doubles=" + getDoubles() + "]" +
                         "[doubles=" + getOutOfJailAttempts() + "]" +
                         "[inJail=" + isInJail() + "]");
                         
   }//end toString method
   
}//end class