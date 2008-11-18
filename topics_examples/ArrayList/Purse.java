//Evan Horgan
//11/5/08

import java.util.ArrayList;

public class Purse
{
     private ArrayList<Coin> coins;
     
     public Purse()
     {
          coins = new ArrayList<Coin> ();
     }
     
     public Purse(ArrayList<Coin> newCoin)
     {
          coins = (ArrayList<Coin>) newCoin.clone();
     }

     public void addCoin (Coin newCoin)
     {
          coins.add (newCoin);
     }
     
     public void reverse ()
     {
          int numCoins = coins.size ();
          
          for ( int i = 0; i < numCoins ; i ++)
          {
               coins.add(i, coins.remove (coins.size() - 1));
          }
     }
     
     
      public void transfer (Purse other)
      {
          int numCoins = other.coins.size() ;
          
           for ( int i = 0; i < numCoins; i ++)
           {
                coins.add(other.coins.remove(0)); 
           }
                    
      }
            
      public boolean sameContents (Purse other)
      {
          if 
           
           for( int i = 0; i < coins.size; i ++)
          {
               
           
           
           
           
           return true;
           
      }
      
      public boolean sameCoins (Purse other)
      {
           return true;
           
      }
      
           
      
     public String toString ()
     {
          String result = "Purse contents : [ ";
          
          for (Coin currentCoin : coins)
               result += currentCoin.getName() + " ";
          result += "]";
          return result;
     }
     
     
     
     
     
}