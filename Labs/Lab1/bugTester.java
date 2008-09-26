public class bugTester
{
     public static void main (String args [])
     {
          bug Bug = new bug (5);
          
          Bug.move();
          Bug.turn();
          Bug.move();
        
          System.out.println (Bug.getPosition());
          }
}
