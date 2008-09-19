import java.awt.Rectangle;

public class AreaTester
{
     public static void main (String args [])
     {
          Rectangle box = new Rectangle (5, 10, 20, 30);
          
          System.out.println ("The area of a Rectangle with width " +
                              box.getWidth() + " and height " +
                              box.getHeight() + " is " +
                              (box.getWidth() * box.getHeight()) + ".");
          
     }
}