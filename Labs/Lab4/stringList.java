//Evan Horgan


import java.util.*;

public class stringList
{
     public static void main (String args [])
     {
          Scanner in = new Scanner (System.in);
          ArrayList strings = new ArrayList();
          
          for (int i = 0; i<10; i++)
          {
               
               System.out.println ("enter your string");
               strings.add(in.nextLine());
          }
          
          for (int i = 10; i > 0; i--)
          {
               System.out.println(strings.get(i-1));
          }
          
     }
     
}