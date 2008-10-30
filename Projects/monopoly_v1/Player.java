public class Player
{
     private String name;
     private int space;
     private int money;
     private int doubles;
     private int whichPiece;
     private boolean inJail;
     
     public Player (String n)
     {
          name = n;
          space = 0;
          money = 1500;
          doubles = 0;
          whichPiece = 0;
          inJail = false;
          
     }
     
     public String getName()
     {
          return name;
     }
     
     
     public void setName(String newName)
     {
          name = newName;
     }
     
     public int getSpace()
     {
          return space;
     }
     
     public void setSpace(int s)
     {
          space = s;
     }
     
     public int movePiece(int numbSpace)
     {
          space += numbSpace;
          if(space > 40)
               space -= 40;
          return space;
     }
     
     public void addDoubles()
     {
          doubles += 1;
     }
     
     public int getDoubles()
     {
          return doubles;
     }
     
     public String resetDoubles()
     {
          doubles = 0;
     }
     
     public boolean isInJail()
     {
          return inJail;
     }
     
     public int getPiece()
     {
          return whichPiece;
     }
     
     public int getMoney()
     {
          return money;
     }
     
     public void setMoney(int m)
     {
          money += m;
     }
}//end
          
     
               
     
     
               
     
     
              
          
     