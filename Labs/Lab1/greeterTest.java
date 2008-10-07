//**Evan Horgan help from Matt Bischoff

public class greeterTest
{
     public static void main (Strig agrs[])
          System.out.println ("New Nameless Greeter");
          Greeter myGreeter = new Greeter ();
          System.out.println (myGreeter.sayHola ());
          System.out.println (myGreeter.sayAdios ());
          System.out.println (myGreeter.refuseHelp ());
          
          System.out.println ("New Evan Greeter");
          Greeter me = new Greeter ("Evan");
          System.out.println (me.sayHola ());
          System.out.println (me.sayAdios ());
          System.out.println (me.refuseHelp ());
     }
}
 
     
     