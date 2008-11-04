public class Digits
{
     public static void main(String [] args)
     {
          System.out.println(numberOfSevens(727723477));               
     }
     
     public static int numberOfSevens (int number)
     {
          String sevens = Integer.toString(number);  
          
          int numSevens = 0;
          
          for(int i = 0; i < sevens.length(); i++)
          {
               if(sevens.charAt(i) == '7')                    
                    numSevens++;
          }
          
          return  numSevens;
          
     }
}

