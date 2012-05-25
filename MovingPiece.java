import java.awt.Image;
import java.util.ArrayList;
public class MovingPiece extends Piece
{   boolean alive=true;
int score=0;
    int dx=0;
    int dy=0;
    int speed;
    
    public MovingPiece(int x,int y,int width,int height,Image img,int speed)
    {
        super(x,y,width,height,img);
        this.speed=speed;
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
        dx=0;
    }
    
    public void stopVertical()
    {
        dy=0;
    }
    
    public void move()
    {
        if(x+dx<448&&x+dx>0)
            x=x+dx;
        
        if (y+dy<419&&y+dy>0)
            y=y+dy;
    }
    
    public void checkIntersect(ArrayList<Person> dan){
        for(Person p : dan)
        {
            if(p.intersects(this))
            {
            p.setDead();
        }
        }
            
    
    }
    public boolean chIntersect(ArrayList<Person> dan){
        for(Person p : dan)
        {
            if(p.intersects(this))
           return true;
        }
        return false;
    }
    
    public void ckIntersect(ArrayList<Obstacle> cars){
        for(Obstacle c : cars)
        {
            if(c.intersects(this))
            {
            c.setDead();
        }
        }
            
    
    }
    
    public boolean cIntersect(ArrayList<Obstacle> cars){
        for(Obstacle c : cars)
        {
            if(c.intersects(this))
           return true;
        }
        return false;
    }
    
    public void ratIntersect(ArrayList<Ratchet> rats){
        for(Ratchet r : rats)
        {
            if(r.intersects(this))
            {
            r.setDead();
        }
        }
            
    
    }
    
    public boolean rIntersect(ArrayList<Ratchet> rats){
        for(Ratchet r : rats)
        {
            if(r.intersects(this))
           return true;
        }
        return false;
    }
    
    public String getScore(String name, int score, int time)
    {
        String n=null;
        return n;
    }
}
