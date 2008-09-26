public class TestCar
{
     public static void main (String [] args)
     {
          Car myCar = new Car (50);
          myCar.addGas(20);
          myCar.drive(100);
          double gasLeft = myCar.getGasInTank();
          
          System.out.println("My car has " + myCar.getGasInTank() + " gallons of gas remaining");
               
     }
}