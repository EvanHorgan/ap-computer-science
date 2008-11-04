import java.util.ArrayList;

public class ArrayListPractice
{
     public static void main (String args [])
     {
          ArrayList words = new ArrayList (); // []
          
          System.out.println ("Current status:\n" + words);
          
          words.add (new String ("Apple")); //[Apple]
          
          System.out.println ("Current status:\n" + words);
          
          words.add (new String ("Banana")); // [Apple, Bannana]
          
          System.out.println ("Current status:\n" + words);
          
          words.add (new String ("Cantaloupe")); // [Apple, Bannana, Cantaloupe]
          
          System.out.println ("Current status:\n" + words);
          
          words.add (1, new String ("Dates")); // [Apple, Dates, Bannana, Cantaloupe]
          
          System.out.println ("Current status:\n" + words);
          
          words.add (1, new String ("Eggfruit")); // [Apple, Eggfruit, Dates, Bannana, Cantaloupe]
          
          //[current status?]
          
          System.out.println ("Current status:\n" + words);
          
          String replacedWord = (String) words.set (0, new String ("Fig"));
          System.out.println ("We just replaced " + replacedWord);
          // [Fig, Eggfruit, Dates, Bannana, Cantaloupe]
          // Apple was replaced
          
          System.out.println ("Current status:\n" + words);
          
          words.add (words.size (), new String ("Grape"));
          // [Fig, Eggfruit, Dates, Bannana, Cantaloupe, Grape]
          
          System.out.println ("Current status:\n" + words);
          
          words.add (new String ("Honeydew"));
          // [Fig, Eggfruit, Dates, Bannana, Cantaloupe, Grape, Honeydew]
          
          String removedWord = (String) words.remove (3);
          System.out.println ("We just removed " + removedWord);
          // [Fig, Eggfruit, Dates, Cantaloupe, Grape, Honeydew]
          //remove bannana
          
          System.out.println ("The last word in the list is " +
                                      words.get (words.size () - 1));
           // [Fig, Eggfruit, Dates, Cantaloupe, Grape, Honeydew]
          //current status is Honeydew
          //last word is?
          
          System.out.println ("Final status:\n" + words);
          
          
     }//end main method
}//end ArrayListPractice class
