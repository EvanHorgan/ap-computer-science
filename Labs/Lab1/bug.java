public class bug
{
     private int position;
     private boolean right;
     
     public bug ()
     {
          position = 0;
          
     }
     public bug (int firstPosition)
     {
          
          position = firstPosition;
              
     }
     
     public void turn()
     {
          if (right)
               right=false;
          else
               right=true;
     }
     public void move()
     {
          if (right)
               position += 1;
          else
               position -=1;
     }
     
     public int getPosition ()
     {
          return position;
     }
}
               
          
          