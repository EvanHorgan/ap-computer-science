// Evan Horgan
//@date 11/5/08


public class Coin
{
     private String name;
     private double value;//instance fields
     
     public Coin (String newName, double newValue)
     {
          name = newName;
          value = newValue;
     }//end constructor
     
     public String getName ()
     { 
          return name;
     }//end getName
     
     public double getValue()
     {
          return value;
     }//end getValue
     
}//end Coin class
     
     