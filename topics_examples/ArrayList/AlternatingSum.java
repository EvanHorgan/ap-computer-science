//Evan Horgan
//11/13/08

public class AlternatingSum
{
     public static void main (String [] args)
     {    
          //int [] numbers = new int [5];
          
          int [] numbers = {1,4,9,16,9,7,4,9,11};
          
          int sum =0;
          
          for( int i =0; i < numbers.length; i ++)
          {
               // int number = 156;
               // if (number % 3 == 0)
               if( i % 2== 0)
               {
                    sum = sum + numbers [i];
               }
               else
               {
                    sum = sum - numbers [i];
               }
               
                    
          }//end for
          
          System.out.println( " the sum = " + sum);
          
     }//end main
}                   //end class
                       
               
          
     
     