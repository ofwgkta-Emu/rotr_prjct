import java.awt.Rectangle; 
import java.awt.Image;

public class Piece extends Rectangle
{
    private Image img;
    
    public Piece(int x,int y,int width,int height,Image img)
    {
        super(x,y,width,height);
        this.img=img;
    }
    
    public Image getImage()
    {
        return img;
    }
    
    public void setImage(Image img)
    {
        this.img=img;
    }
}
