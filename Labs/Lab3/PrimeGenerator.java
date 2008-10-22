//Evan Horgan
//with help from matt's repository

public class PrimeGenerator
{
     private int number, currentNumber;
     private boolean isFinished = false;
     
     public PrimeGenerator (int anumber)
        
     {
          number = anumber;
    currentNumber = 1;
  }
 
  public boolean isDone()
  {
    int oldNumber = currentNumber;
    
    if(nextPrime() > number)
      return true;
    else
    {
      currentNumber = oldNumber;
      return (currentNumber >= number);
    }
    
     }
     
     
     public int nextPrime ()
     {
          
          currentNumber ++;
           while (currentNumber <= number)
    {
      boolean isPrime = true;
 
      for(int i=2; i <= currentNumber/2; i++) //use bisecion
      {
        if(currentNumber%i == 0) // check for divisibility
        {
          isPrime = false;
        }
      }
 
      if(isPrime)
        return currentNumber;
      else
        currentNumber++;
 
    }//end while
          //keep looping until we find a prime number
          
               //inside the loop have a second loop to test if the currentNumber is prime.
               //if it is, exit the outer loop
               //else, increment currentNumber by 1.
          
          //When we exit the outer loop, return currentNumber
          return currentNumber;
     }
}