//Evan Horgan
//11/12/08

public class purseTester
{
     public static void main (String args[])
          
     {
          Purse myPurse = new Purse();
          myPurse.addCoin(new Coin ("Dime", 0.1));
          myPurse.addCoin(new Coin ("Nickel", 0.05));
          myPurse.addCoin(new Coin ("Dime", 0.1));
          myPurse.addCoin(new Coin ("Quarter", 0.25));
          
           Purse otherPurse = new Purse();
          otherPurse.addCoin(new Coin ("Penny", 0.01));
          otherPurse.addCoin(new Coin ("Penny", 0.01));
          otherPurse.addCoin(new Coin ("Dime", 0.1));
          
          
          System.out.println (myPurse);
          
          myPurse.reverse ();
          
          
          System.out.println (myPurse);
          System.out.println (otherPurse);
          
          myPurse.transfer (otherPurse);
          
          
          System.out.println (myPurse);
          System.out.println (otherPurse);
          
          
     }
}