import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/*
 * todo list
 * fix gameover.png in sumopaint
 * add in rockets only get 5, until pickup ammo
 * add in a timer to show longest time recorded
 * add in an explosion if colide with cops
 * add in timer to grauall incease dificulty over time
 * add in online/offline score board
 */

public class Board extends JPanel implements ActionListener
{//do not change these 2 int values!
   int value=0;
    int count=0;
    boolean stop=false;
  boolean gameover=false;
   

    MovingPiece player;
    ArrayList<Person> dan=new ArrayList<Person>(); //list of peoples
    ArrayList<Obstacle> cars=new ArrayList<Obstacle>(); //list of cop cars, will be adding different images soon
    ArrayList<Ratchet> rats=new ArrayList<Ratchet>();//list of health packs
    Image img; //background
    Image img2; //green player car
    Image img3; //Person
    Image img4;//blood
    Image img5; //oppsing cars
    Image img6; //game over
    Image img7; //ratchet aka hp
    Image img8; //hp++
    Image img9;//green/yellow car
    Image img10;// yellow car
    Image img11; //yellow/orange
    Image img12; //orange
    Image img13; // red/orange
    Image img14; //red
    Timer time;
    
    int playerspeed=6;
    int carspeed=4;
    int hp=100;
    int score=0;
   
   
   public Board()
   {//set this window to be the one receiving keystrokes
       setFocusable(true);
       //add the key events
       addKeyListener(new AL());
       
       //extract an image from a file (the background)
       //*****YOU WILL NEED TO FIND/CREATE A BACKGROUND IMAGE********
       ImageIcon i=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/background.png");
       img=i.getImage();
       
       //extract an image from a file (the player)
       //******YOU WILL NEED TO FIND/CREATE A PLAYER IMAGE**********
       ImageIcon i2=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/dude.png"); //facing right
       img2=i2.getImage();
       
       //Random person
       ImageIcon i3=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/person.png");
       img3=i3.getImage();
       
       ImageIcon i4=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/blood.png"); //the blood when running over people
       img4=i4.getImage();
       
       ImageIcon i5=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/ocars.png"); //opposing cars
       img5=i5.getImage();
       
       ImageIcon i6=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/gameover.png"); //gameover bg
       img6=i6.getImage();
       
       ImageIcon i7=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/hp.png"); //wrench
       img7=i7.getImage();
       
       ImageIcon i8=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/hp++.png"); //hp++
       img8=i8.getImage();
       
       ImageIcon i9=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/gy.png"); //green/yellow
       img9=i9.getImage();
       
       ImageIcon i10=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/y.png"); //yellow
       img10=i10.getImage();
       
       ImageIcon i11=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/yo.png"); //yellow/orange
       img11=i11.getImage();
       
       ImageIcon i12=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/o.png"); //orange
       img12=i12.getImage();
       
       ImageIcon i13=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/ro.png"); //orange red
       img13=i13.getImage();
       
       ImageIcon i14=new ImageIcon("/home/shaqdb/Desktop/works/Blah_blah/images/r.png"); //red
       img14=i14.getImage();
      
       //create a new player
       player=new MovingPiece(0,0,55,45,img2,carspeed);
       
       //the screen will refresh every 4 milliseconds
       time=new Timer(4,this);
       time.start();
    }
    
    //the timer controls the execution of this method, it will execute it every 5 milliseconds
    public void actionPerformed(ActionEvent e)
    { count++;
        
        //spawn random people all the time at preset x and a random location y
        if(count%50==0)
        {dan.add(new Person(545,(int)(Math.random()*420),45,45,img3,playerspeed));}
        if(count%100==0)
        {dan.add(new Person(545,(int)(Math.random()*420),45,45,img3,playerspeed));}
        
        
        //spawn random cars at prest x and random y
        if(count%245==0)
        {cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,7));}
        if(count%238==0)
        {cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,7));}
        if(count%150==0)
        {cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,7));}
        if(count%420==0)
        {cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,7));}   
        if(count%780==0)
        {cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,7));}
            
            
        //health at preset x and random y
            if(count%2000==0)
            {rats.add(new Ratchet(545,(int)(Math.random()*420),50,50,img7,4));}
            if(count%6500==0)
            {rats.add(new Ratchet(545,(int)(Math.random()*420),50,50,img7,4));}
            if(count%8850==0)
            {rats.add(new Ratchet(545,(int)(Math.random()*420),50,50,img7,4));}
            
            //difficulty increase to medium by adding cars with 1+ speed and faster spawn time
            if(count>5000)
            {carspeed=5;
                if(count%80==0)
                cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,8));
            }
            //difficulty increase to hard, same as the if statement above
            if(count>15000)
            { if(count%40==0)
                cars.add(new Obstacle(545,(int)(Math.random()*420),50,50,img5,9));
            }
            
            
            
        //tell the player to move
        player.move();
        player.checkIntersect(dan);
        player.ckIntersect(cars);
        player.ratIntersect(rats);
        
        //checks
        if(player.chIntersect(dan)==true&&stop==false)
        {score++;}
        if(player.cIntersect(cars)==true&&hp>0)
        {hp--;
        score--;
        }
        if(player.rIntersect(rats)==true&&hp>0)
        {hp++;}
        if(hp>100)
        {hp=100;};
        if(hp==0)
        {stop=true;
            gameover=true;
        }
        if(score<0)
        {score=0;}
        
        //player color hp indicator
        if(hp>90)
        player.setImage(img2);
        if(hp<=90&&hp>=80)
        player.setImage(img9);
        if(hp<80&&hp>=70)
        player.setImage(img10);
        if(hp<70&&hp>=60)
        player.setImage(img11);
        if(hp<60&&hp>=50)
        player.setImage(img12);
        if(hp<50&&hp>=40)
        player.setImage(img13);
        if(hp<40&&hp>0)
        player.setImage(img14);
        
        
        //move the people
        for(Person p : dan)
        {p.move();}
            //move the police cars
        for(Obstacle c : cars)
          {c.move();}
          //move the wrenches for the hp stuff...
          for(Ratchet r : rats)
        {r.move();}
        
        //redraw the screen
        repaint();
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D g2d=(Graphics2D) g;
        
        if(gameover==false)
        {//draw the background image
            g2d.drawImage(img,value,0,null); //side
        g2d.drawImage(img,500+value,0,null); //scrolling
        value=value-5;//stops
        if(value==-500)//at this
            value=0; //line
        
        g2d.drawString("Score:"+score,7,10);
        g2d.drawString("Health:"+hp,420,10);

        
        //draw person named dan aka random stick figure dood
        for(Person p : dan)
        { if(p.alive==true)
          {g2d.drawImage(p.getImage(),(int)p.getX(),(int)p.getY(),null);}
           else
            {p.setImage(img4); 
                g2d.drawImage(p.getImage(),(int)p.getX(),(int)p.getY(),null);
            }if(player.alive==true)
            {g2d.drawImage(player.getImage(),(int)player.getX(),(int)player.getY(),null);}
        }
       
        
        //draw police cars 
        for(Obstacle c : cars)
        {if(c.alive==true)
            {g2d.drawImage(c.getImage(),(int)c.getX(),(int)c.getY(),null);}
            else
            {c.setImage(img3);
                g2d.drawImage(c.getImage(),(int)c.getX(),(int)c.getY(),null);
            }if(player.alive==true)
            {g2d.drawImage(player.getImage(),(int)player.getX(),(int)player.getY(),null);}
        }
        
        
        //draw health
        for(Ratchet r : rats)
        {if(r.alive==true)
            {g2d.drawImage(r.getImage(),(int)r.getX(),(int)r.getY(),null);}
            else
            {r.setImage(img8);
                g2d.drawImage(r.getImage(),(int)r.getX(),(int)r.getY(),null);
            }if(player.alive==true)
            {g2d.drawImage(player.getImage(),(int)player.getX(),(int)player.getY(),null);}
        }
    }
    else //game over screen
    {g2d.drawImage(img6,0,0,null);}
        
    }
    
    //the key listener, it is a private class inside of our Board class
    private class AL extends KeyAdapter
    {
       public void keyPressed(KeyEvent e)
       {
           
           //get the key code of the key event
           int key=e.getKeyCode();
        
                 //if the keycode is the left movement keycode then move left
                    if (key==KeyEvent.VK_LEFT)
                    {
                        player.back();
                    }
                //if the right movement button is pressed ...
                    if(key==KeyEvent.VK_RIGHT)
                    {
                        player.ahead();
                    }
                 //if the up movement button is pressed ..
                    if(key == KeyEvent.VK_UP)
                    {
                        player.up();
                    }
                 //if the up movement button is pressed ..
                    if(key == KeyEvent.VK_DOWN)
                    {
                        player.down( );
                    }
                }


       public void keyReleased(KeyEvent e)
       {
           
           //get the keycode of the key that was released
           int key = e.getKeyCode();

                 //if the left movement button is released
                    if (key==KeyEvent.VK_LEFT)
                        player.stopHorizontal();
                //if the right movement button is released
                    if (key==KeyEvent.VK_RIGHT)
                        player.stopHorizontal();
                //if the up movement button is pressed
                    if (key==KeyEvent.VK_UP)
                        player.stopVertical();
                //if the up movement button is pressed
                    if (key == KeyEvent.VK_DOWN)
                        player.stopVertical();

        }     
    }    
}   

