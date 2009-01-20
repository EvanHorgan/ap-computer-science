/**
 * This is the main class of the Monopoly game.
 * <p>
 * See the individual methods for game explanation.
 * 
 * @author Evan Horgan
 */

//YOU MUST IMPORT THE FOLLOWING
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;

public class Monopoly
{
//THESE VARIABLES ARE OPTIONAL
   public static final int NUM_SPACES = 40;
   public static final int MAX_OUT_OF_JAIL_ATTEMPTS = 3;
   
//THESE VARIABLES ARE MANDATORY (I recommend using these names)
   public static ArrayList<Player> players;
   public static ArrayList<Property> properties;
   public static Die roller;
   public static Token tokens;
   public static MonopVars vars;
   public static Scanner in;

//USE MY MAIN METHOD AS A GUIDE FOR BUILDING YOUR PROGRAM
   /**
    * This is the main method of the program.
    * 
    * @param args this is the necessary String array (not used).
    */
   public static void main (String args[]) throws IOException, BadDataException
   {
      boolean quitGame = false;
      int whoseTurn = 0;
      
//YOU MUST INCLUDE THIS LINE OF CODE
      initializeData ();
      
//THE REMAINING CODE IS OPTIONAL
      //print the opening message
      System.out.println (getOpeningMessage ());

      //receive all player information
      //receivePlayerInformation();
      Player p1 = new Player ("Tom", 0);
      Player p2 = new Player ("Evan", 1);
      players.add (p1);
      players.add (p2);
      
      
      
      
      //show the instructions if the user wishes to see them.
      if (chooseShowInstructions ())
         showInstructions ();
      
      //print the message to begin the game.
      System.out.println (getStartGameMessage ());

      //loop until a player chooses to quit the game
      do
      {
         Player curPlayer = players.get(whoseTurn);
         System.out.print ("\n\n\n*************************************" +
                        "\n     * * * * * * * * * * * * * *     " +
                        "\n*************************************\n");
         if (!curPlayer.isInJail ())
            quitGame = performTurn (curPlayer);
         else
            quitGame = performJailTurn (curPlayer);
         
         whoseTurn++;
         
         if (whoseTurn == players.size())
            whoseTurn = 0;
      }
      while (!quitGame);

   }//end main method
   
   
   /**
    * This method prints a menu of choices for the player 
    * to choose from on each turn.
    * 
    * @return a char representing the player's choice.
    */
   public static int enterMenuChoice (Player player)
   {
        System.out.println (player.getName() + ", it is your turn, what would you like to do?");
        System.out.print ("\t1: Roll\n\t2: Quit\nEnter choice: ");
        
        return in.nextInt();
        
   }//end enterMenuChoice method
   
   
   /**
    * Perform the proper game action based upon the player's choice.
    * <p>
    * Precondition: The <code>enterMenuChoice</code> method should
    * be called and the result sent as the parameter <code>choice</code>.
    * 
    * @param player the player taking the turn.
    */
   public static boolean performTurn (Player player)
   {
        boolean done = false;
        do{
             int choice = enterMenuChoice (player);
             
             if (choice == 1)
             {
                  int die1 = roller.nextRoll ();
                  int die2 = roller.nextRoll ();
                  int diceTotal = die1 + die2;
                  if(die1 != die2)
                  {
                       System.out.println ("You rolled a " + die1 + " and a " + die2 + ". Move forward " + diceTotal + " spaces.");
                       player.movePiece(diceTotal);
                       done = true;
                  }
                  else
                  {
                       if(player.getDoubles() < 2)    
                       {
                            player.addDoubles();
                            System.out.println ("You rolled two " + die1 + "'s. Move forward " + diceTotal + " spaces and roll again");
                       }
                       else
                       {
                            player.addDoubles();
                            System.out.println("You rolled doubles three times in a row and must go to jail.");
                       }
                  }
                  
                  
             }//end if
             else if (choice == 2)
             {
                  return true;
             }//end else if
             else
             {
                  System.out.println ("Invalid input");
             }//end else
             
        }while(!done);
        return false;
   }//end performTurn method
   
   
   /**
    * This method prints a menu of choices for the player 
    * to choose from if in jail.
    * 
    * @return a char representing the player's choice.
    */
   public static int enterJailMenuChoice (Player player)
   {
        return 1;
   }//end enterJailMenuChoice method
   
   
   /**
    * Perform the proper action for getting out of jail based upon
    * the player's choice.
    * <p>
    * Precondition: The <code>enterJailMenuChoice</code> method should
    * be called and the result sent as the parameter <code>choice</code>.
    * 
    * @param player the player taking the turn.
    */
   public static boolean performJailTurn (Player player)
   {
        return false;
   }//end performJailTurn method
   

   
   
//ADD THE FOLLOWING TWO METHODS
   /*
    * This method initializes all data for the game.
    */
   public static void initializeData () throws IOException, BadDataException
   {
      boolean fileFound = false;
      
      //Initialize the objects
      in = new Scanner (System.in);
      players = new ArrayList<Player>();
      properties = new ArrayList<Property>();
      tokens = new Token();
      vars = new MonopVars();
      MonopolyDataReader reader = new MonopolyDataReader();
      
      do
      {
         //try to obtain a valid file
         try
         {
            reader.readMonopolyFile (chooseFile(), vars, tokens, properties);
            fileFound = true;
         }//end try
         catch (FileNotFoundException e)
         {
            System.out.println ("\n\nFile not found.  Please try again.");
         }//end catch
      }//end do
      while (!fileFound);
      
      roller = new Die (vars.getNumDiceSides());
         
   }// end of initializeData method
   
   
   /*
     * This method uses a JFileChooser to locate the data file
     * to be used in this version of Monopoly.
     * 
     * @return the name of the file to be used for this game
     */

   public static String chooseFile ()
   {
      String filename = new String();
      boolean fileChosen = false;
      
      //This window is the parent for the JFileChooser
      JWindow window = new JWindow();
      
      //YOU CAN CHANGE THE INITIAL PATH FOR THE JFileChooser TO LOOK IN!
      //Perhaps the Desktop?
      JFileChooser chooser = new JFileChooser ("/users/ehorgan/Desktop/monopoly_v2 - Dietzler version/MonopolyData.txt");
      
      do
      {
         try
         {
            //Opens the JFileChooser
            chooser.showOpenDialog(window);
            
            //Returns the name of the file that was chosen.
            filename = chooser.getName (chooser.getSelectedFile());
            fileChosen = true;
         }//end try
         catch (NullPointerException e)
         {
            System.out.println ("Please choose a file before continuing.");
         }//end catch
      }
      while (!fileChosen);
      
      return filename;
   }// end of chooseFile method
   
   
   
   
   
//THE REMAINING METHODS ARE OPTIONAL
   /**
    * This method can be altered to incorporate different welcome messages.
    * 
    * @return returns the message.
    */
   public static String getOpeningMessage ()
   {
      return new String ("\n\n\n\n\n\n\n\n\n" +
        "**    ** ****** ***  ** ****** ****** ****** **  **     **\n" +
        "***  *** **  ** **** ** **  ** **  ** **  ** **   **   ** \n" +
        "******** **  ** **** ** **  ** ****** **  ** **    ** **  \n" +
        "***  *** **  ** *** *** **  ** **     **  ** **     ***   \n" +
        "***  *** **  ** ***  ** **  ** **     **  ** *****  ***   \n" +
        "***  *** ****** ***  ** ****** **     ****** *****  ***   \n" +
        "\n\n" + (vars.getVersion()).toUpperCase() + " EDITION");
   }//end getOpeningMessage method
   
   
   /**
    * This method receives all information for and initializes the player
    * objects.
    */
   public static void receivePlayerInformation ()
   {
      String nameEntry = new String ();
      int pieceChoice = 0, numPlayers = 0;
      char choice;
      
      //Receive the number of players
      numPlayers = enterNumPlayers();
      
      for (int i = 0; i < numPlayers; i++)
      {
         //receive the player's name and token
         nameEntry = enterPlayerName (i+1);
         pieceChoice = chooseToken (nameEntry);
      
         players.add(new Player (nameEntry, pieceChoice));
      }//end for
   }//end receive player information method
   
   
   /**
    * This method allows entry for the number of players.
    * 
    * @return a valid number of players (between 2 and
    * <code>tokens.getNumTokens()</code>).
    */
   public static int enterNumPlayers ()
   {
      char choice = ' ', yesOrNo = ' ';
      int numPlayers = 2;
      boolean validInput = true, numCorrect = true;
      
      System.out.print ("\nPlease enter the number of players (between 2 and " +
                        tokens.getNumTokens() + "): ");
      
      do
      {
         try
         {
            numPlayers = in.nextInt ();
            if (numPlayers < 2 || numPlayers > tokens.getNumTokens())
            {
               System.out.print ("\n" + numPlayers + " is not a valid number of players.\n" +
                                   "Please choose a number between 2 and " +
                                   tokens.getNumTokens() + ": ");
               validInput = true;
               numCorrect = false;
            }
            else
            {
               System.out.print ("\n" + numPlayers + " players: Is this correct? (y or n): ");
               validInput = false;
            }
            
            while (!validInput)
            {
               try
               {
                  yesOrNo = Character.toLowerCase (in.next ().charAt (0));
                  
                  switch (yesOrNo)
                  {
                     case 'y':
                        validInput = true;
                        numCorrect = true;
                        break;
                     case 'n':
                        numCorrect = false;
                        System.out.print ("\nPlease re-enter the number of players (between 2 and " +
                                          tokens.getNumTokens() + "): ");
                        validInput = true;
                        break;
                     default:
                        System.out.print ("\nOnly enter y or n.  Please re-enter: ");
                        validInput = false;
                        break;
                  }//end switch
               }//end try
               catch (StringIndexOutOfBoundsException e)
               {
                  System.out.print ("\nYou did not enter a value.  Please enter y or n: ");
                  validInput = false;
               }//end catch
            }//end while
         }//end try
         catch (IllegalArgumentException e)
         {
            System.out.print ("\nInvalid entry.  Please choose a number between 2 and " +
                              tokens.getNumTokens() + ": ");
            numCorrect = false;
         }
         catch (NoSuchElementException e)
         {
            System.out.print ("\nYou did not enter a value.  Please choose a number between 2 and " +
                              tokens.getNumTokens() + ": ");
            numCorrect = false;
         }
      }//end do
      while (!numCorrect);
      
      return numPlayers;
   }//end enterNumPlayers method
   
   
   /**
    * This method allows one player to enter his/her name.
    * 
    * @return returns a valid name.
    */
   public static String enterPlayerName (int num)
   {
      char choice = ' ', yesOrNo = ' ';
      String pName;
      boolean validInput = true, nameCorrect = true;
      
      System.out.print ("\nPlease enter the " + num + getSuffix (num) + " player's name: ");
      
      do
      {
         pName = in.next ();
         if (pName.equals ("") || pName.replaceAll (" ","").equals (""))
         {
            System.out.print ("\nYou did not enter a name.\n" + 
                                   "Please re-enter: ");
            validInput = true;
            nameCorrect = false;
         }
         else
         {
            System.out.print ("\nYou entered \"" + pName + "\": Is this correct? (y or n) ");
            validInput = false;
         }
         
         while (!validInput)
         {
            try
            {
               yesOrNo = in.next ().charAt (0);
               yesOrNo = Character.toLowerCase (yesOrNo);
               switch (yesOrNo)
               {
                  case 'y':
                     validInput = true;
                     nameCorrect = true;
                     break;
                  case 'n':
                     nameCorrect = false;
                     System.out.print ("\nPlease re-enter your name: ");
                     validInput = true;
                     break;
                  default:
                     System.out.print ("\nOnly enter y or n.  Please re-enter: ");
                     validInput = false;
                     break;
               }//end switch
            }//end try
            catch (StringIndexOutOfBoundsException e)
            {
               System.out.print ("\nYou did not enter a value.  Please enter y or n: ");
               validInput = false;
            }//end catch
         }//end while
      }//end do
      while (!nameCorrect);
      
      return pName;
   }//end enterPlayerName method
   
   
   /**
    * This method allows a player to choose from the list of tokens
    * 
    * @param playerName the player who is choosing the token
    */
   public static int chooseToken (String playerName)
    {
        // i and j will be standard variables for the for loops.
        int i, j;
        
        int indexOfPiece = -1;
        
        boolean tokenChosen;
        boolean yesNoInput = true;
        char yesOrNo;
        
        // Have the user choose a valid token as their piece.
        do
        {
            tokenChosen = true;
            
            try
            {
                // Print out a menu of available tokens.
                System.out.println ("\nHere is a list of available tokens" + 
                                    "(an \"X\" means a token has been chosen):");
                for (i = 0; i < tokens.getNumTokens(); i++)
                {
                    if (!tokenChosen(i))
                        System.out.println ((i + 1) + ": " + tokens.getTokenName(i));
                    else
                        System.out.println ("X: " + tokens.getTokenName(i));
                }
        
                System.out.print ("\nEnter the number of the token you would " +
                                  "as your piece, " + playerName + ": ");
                indexOfPiece = in.nextInt ();
                
                if (indexOfPiece < 1 || indexOfPiece > tokens.getNumTokens())
                {
                    System.out.println ("\nNumber must be between 1 and " +
                                        tokens.getNumTokens() + ".");
                    tokenChosen = false;
                }
                else if (tokenChosen ((indexOfPiece - 1)))
                {
                    System.out.println ("\nSorry, but the " + tokens.getTokenName(indexOfPiece - 1) +
                                        " has already been chosen.  Please choose a different token.");
                    tokenChosen = false;
                }
            }
            catch (NoSuchElementException e)
            {
               System.out.print ("\nYou did not enter a value.\nPlease choose a valid option from the menu\n");
               tokenChosen = false;
            }//end catch
            catch (IllegalArgumentException e)
            {
               System.out.print ("\nInvalid entry." +
                                 "\nPlease choose a valid option from the menu\n");
               tokenChosen = false;
            }//end catch
            
            if (tokenChosen)
            {
               System.out.print (playerName + ", you chose the " +
                                 tokens.getTokenName(indexOfPiece - 1) +
                                 ".  Is this correct?\nEnter y or n: ");
               yesNoInput = false;
               
               while (!yesNoInput)
               {
                  try
                  {
                     yesOrNo = Character.toLowerCase (in.next ().charAt (0));
                     
                     switch (yesOrNo)
                     {
                        case 'y':
                           yesNoInput = true;
                           tokenChosen = true;
                           break;
                        case 'n':
                           tokenChosen = false;
                           System.out.print ("\nPlease re-choose your token.\n");
                           yesNoInput = true;
                           break;
                        default:
                           System.out.print ("\nOnly enter y or n.  Please re-enter: ");
                           yesNoInput = false;
                           break;
                     }//end switch
                  }//end try
                  catch (StringIndexOutOfBoundsException e)
                  {
                     System.out.print ("\nYou did not enter a value.  Please enter y or n: ");
                     yesNoInput = false;
                  }//end catch
               }//end while
            }//end if
        }//end do
        while (!tokenChosen);
        
        System.out.println (playerName + " chose the " +
                                tokens.getTokenName(indexOfPiece - 1) + ".");
            
        return (indexOfPiece - 1);
    } // end of chooseToken method
    
    
    /*
     * precondition: tokenIndex is the index of the token being checked to see if
     *               a different player chose already.
     * 
     * @param tokenIndex the index of the token in question
     * @return true if the token has been chosen by another player; false
     * if otherwise
     */
   public static boolean tokenChosen (int tokenIndex)
   {
      
      for (int i = 0; i < players.size(); i++)
         if (players.get(i).getPiece () == tokenIndex)
         return true;
      
      return false;
   }// end of tokenChosen method
   
   
   /**
    * This method prompts the player whether or not 
    * to see the instructions.
    * 
    * @return returns true if the player wished to see 
    * the instructions; false if otherwise.
    */
   public static boolean chooseShowInstructions ()
   {
      char yesOrNo = ' ';
      boolean validInput = false;
      
      System.out.print ("\n\nOk, would you like to see the instructions? (y or n) ");
      
      while (!validInput)
      {
         try
         {
            yesOrNo = in.next ().charAt (0);
            yesOrNo = Character.toLowerCase (yesOrNo);
            switch (yesOrNo)
            {
               case 'y':
                  return true;
               case 'n':
                  return false;
               default:
                  System.out.print ("\nOnly enter y or n.  Please re-enter: ");
                  validInput = false;
                  break;
            }//end switch
         }//end try
         catch (StringIndexOutOfBoundsException e)
         {
            System.out.print ("\nYou did not enter a value.  Please enter y or n: ");
            validInput = false;
         }//end catch
      }//end while
      
      return true;
   }//end chooseShowInstructions method
   
   
   /**
    * This method prints the table of contents for the instructions
    * and asks the player which instructions to show.
    */
   public static void showInstructions ()
   {
      char whichInstructions = ' ', yesOrNo = ' ';
      boolean showAgain = true, validInput = false;
      
      do
      {
         System.out.println ("\nWhich section(s) would you like to see?\n\t" +
                             "1. Show all\n\t" +
                             "2. Rolling the Dice\n\t" +
                             "3. Passing GO\n\t" +
                             "4. Rolling Doubles\n\t" +
                             "5. Going to Jail\n\t" +
                             "6. Getting Out of Jail\n\t" +
                             "7. Buying Property\n\t" +
                             "8. Paying Rent\n" +
                             
                             "Please choose a number option: ");
         validInput = false;
         
         while (!validInput)
         {
            try
            {
               validInput = true;
               whichInstructions = in.next ().charAt (0);
               switch (whichInstructions)
               {
                  case '1':
                     showAllInstructions ();
                     break;
                  case '2':
                     MonopolyInstructions.rollingTheDice ();
                     break;
                  case '3':
                     MonopolyInstructions.passingGO ();
                     break;
                  case '4':
                     MonopolyInstructions.rollingDoubles ();
                     break;
                  case '5':
                     MonopolyInstructions.goingToJail ();
                     break;
                  case '6':
                     MonopolyInstructions.gettingOutOfJail ();
                     break;
                  case '7':
                     MonopolyInstructions.buyingProperty ();
                     break;
                  case '8':
                     MonopolyInstructions.payingRent ();
                     break;
                  default:
                     System.out.print ("\nInvalid choice.  Please re-enter: ");
                     validInput = false;
                     break;
               }//end switch
            }//end try
            catch (StringIndexOutOfBoundsException e)
            {
               System.out.print ("\nYou did not enter a value.\nPlease choose a valid option from the menu: ");
               validInput = false;
            }//end catch
         }//end while
         
         System.out.print ("\n\nWould you like to see more instructions? (y or n) ");
         validInput = false;
         
         while (!validInput)
         {
            try
            {
               yesOrNo = in.next ().charAt (0);
               yesOrNo = Character.toLowerCase (yesOrNo);
               switch (yesOrNo)
               {
                  case 'y':
                     validInput = true;
                     showAgain = true;
                     break;
                  case 'n':
                     showAgain = false;
                     System.out.print ("\nReturning to game...");
                     validInput = true;
                     break;
                  default:
                     System.out.print ("\nOnly enter y or n.  Please re-enter: ");
                     validInput = false;
                     break;
               }//end switch
            }//end try
            catch (StringIndexOutOfBoundsException e)
            {
               System.out.print ("\nYou did not enter a value.  Please choose y or n: ");
               validInput = false;
            }//end catch
         }//end while
      }//end do
      while (showAgain);
   }//end showInstructions method
   
   
   /**
    * Displays ALL instructions one by one.
    */
   public static void showAllInstructions ()
   {
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.rollingTheDice ();
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.passingGO ();
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.rollingDoubles ();
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.goingToJail ();
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.gettingOutOfJail ();
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.buyingProperty ();
      System.out.println ("\n(Press ENTER to continue)");
      in.next ();
      MonopolyInstructions.payingRent ();
   }//end showAll method
   
   
   /**
    * This method returns a message to begin the game.
    * 
    * @return returns the message to begin the game.
    */
   public static String getStartGameMessage ()
   {
      return new String ("\n\n\nWelcome to " + vars.getVersion() + "!");
   }//end getStartGameMessage method
   
   
   /**
    * This method returns a message to end the game.
    * 
    * @return returns the message to end the game.
    */
   public static String getEndGameMessage ()
   {
      String message = new String ("\n\nThank you for playing!\n" + 
                                   "Final status: ");
      for (int i = 0; i < players.size(); i++)
         message += "\n" + players.get(i);
      message+= "\n\nPlease play again soon!";
     
      return message;
   }//end getEndGameMessage method
   
      
   /**
    * This method returns the suffix of the given number.
    * 
    * @param number the number to find the suffix for
    * @return returns the suffix of the number as a String.
    */
   public static String getSuffix (int number)
   {
      if ((number % 10) == 1 && ((number / 10) % 10) != 1)
         return new String ("st");
      else if ((number % 10) == 2 && ((number / 10) % 10) != 2)
         return new String ("nd");
      else if ((number % 10) == 3 && ((number / 10) % 10) != 3)
         return new String ("rd");
      else
         return new String ("th");
      
   }//end getSuffix method
   
}//end class