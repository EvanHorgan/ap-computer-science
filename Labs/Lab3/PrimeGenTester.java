public class PrimeGenTester
{
  public static void main (String args [])
  {
    PrimeGenerator pg = new PrimeGenerator (100);
    
  while (!pg.isDone())
    System.out.println (pg.nextPrime());
    
  }
}