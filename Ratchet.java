import java.awt.Image;
import java.util.ArrayList;
public class Ratchet extends Piece
{
   int dx;
    int dy=0;
    int speed;
    int score;
    boolean alive = true;
    public Ratchet(int x,int y,int width,int height,Image img,int speed)
    {
        super(x,y,width,height,img);
        this.speed=speed;
        dx=-speed;
    }
    
    public int getDx()
    {
        return dx;
    }
    
    public int getDy()
    {
        return dy;
    }
    
    public void ahead()
    {
        dx=speed;
    }
    
    public void back()
    {
        dx=-speed;
    }
    
    public void up()
    {
        dy=-speed;
    }
    
    public void down()
    {
        dy=speed;
    }
    
    public void stopHorizontal()
    {
        dx=-speed;
    }
    
    public void stopVertical()
    {
        dy=0;
    }
    
    public void move()
    {
       // if(x+dx<448&&x+dx>0)
            x=x+dx;
        
       // if (y+dy<419&&y+dy>0)
            y=y+dy;
    }
    public void setDead()
    {
        alive=false;
}
}
