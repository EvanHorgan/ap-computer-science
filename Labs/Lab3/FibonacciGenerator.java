// Evan Horgan
//10/8/08
// 1 1 2 3 5 8 13 21 34
//mr. dietzler brinkman

public class FibonacciGenerator
{
     //Declare all instance fields
     private int fold1;
     private int fold2;
     private int fnew;
     
     //Constructor(s)
     public FibonacciGenerator ()
     {
          fold1 = 0;
          fold2 = 0;
          fnew = 1;
     }//end constructor
     
     
     //Methods
     public int nextNumber()
     {
          int  returnVal = fnew;
          
          fold2 = fold1;
          fold1 = fnew;
          fnew = fold1 + fold2;
          return returnVal;
     }
}


