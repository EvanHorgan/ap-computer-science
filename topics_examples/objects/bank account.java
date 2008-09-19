public class BankAccount
{
     instance fields (values) and PUBLIC STATIC VARIABLES ( constrants)
      private double balance; //no specific value assigned yet
     
     //CONSTRUCTOR(S)
     ////defalt constructor
     public BankAccount ()
     {
          balance = 0.0;
     }
     //this constructor sets an initial amount for balance
     public BankAccount (double initBalance)
     {
          balance = initBalance
     }
     
     //3. Methods (actions) that this object can preform
     public double getBalance()
     {
          return balance;
     }//end get balanced method
     
     public void depsosit (double amount)
     {
          balance = balance + amount;
     }//end deposit method
     
}