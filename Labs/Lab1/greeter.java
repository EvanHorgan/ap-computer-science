public class greeter
{
     private String name;
     
     public greeter ()
     
     {
          
     }
     
     public greeter (String initName)
     {
          name = initName;
     }
     
     public String sayHello ()
     {
          if (name == null)
               return ("Hola.");
          else
               return ("Hola" + name + ".");
     }
     
     public String sayGoodbye ()
     {
          if (name == null)
               return ("Adios");
          else
               return ("Adios" + name + ".");
     }
}