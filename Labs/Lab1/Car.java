public class Car
{
     private double milesPerGallon;
     private double fuelLeft;
     
     public Car (double mpg)
     {
          milesPerGallon = mpg;
          fuelLeft = 0;
          
     }
     
     
     public double getmpg()
     {
          return milesPerGallon;
     }
      public double getGasInTank()
     {
          return fuelLeft;
     }
     
     
     public void addGas (double gasAmount)
     {
          fuelLeft = fuelLeft + gasAmount;
     }
     
     public void drive (double driveTime)
     {
          double gallonsUsed = driveTime / milesPerGallon;
          fuelLeft = fuelLeft - gallonsUsed;
     }
}
         