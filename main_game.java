import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class main_game extends JPanel implements KeyListener, MouseListener
{
  static boolean fact1=false;
  static boolean fact2=false;
  static boolean fact3=false;
  static boolean fact4=false;
  static boolean fact5=false;
  static boolean fact6=false;
  boolean stoppedx=false;
  boolean stoppedy=false;
  boolean playermovey=false;
  boolean playermovex=false;
    static int playerx=450;
   static  int playery=350;
    int maxboundsx=5000;
    int maxboundsy=5000;
    boolean credits=false;
    int xclickloc=0;
    int yclickloc=0;
    static boolean upPressed = false;
    static boolean downPressed = false;
    static boolean leftPressed = false;
    static boolean rightPressed = false;
    public boolean startscreen=true;
    public boolean loop=true;
    public static boolean epressed=false;
    int friction=50;
    public static int y=0;
    public static int x=0;
    public static int ySpeed=0;
    public static int xSpeed=0;
    int acceleration=200;
    int maxSpeed=1000;
    int frame_rate=16;//dont change this
    public int speed=300;
    BufferedImage image;
    Image background, player,pausedscreen, creditscreen, factscreen1, factscreen2, factscreen3, factscreen4, factscreen5, factscreen6;

    
    public main_game()
    {
      addMouseListener(this);
      setFocusable(true);
     addKeyListener(this);
     setFocusable(true);
    background=readImage("plutonium.png").getScaledInstance (maxboundsx*2, maxboundsy*2, Image.SCALE_DEFAULT);
    player=readImage("player.png").getScaledInstance (100, 100, Image.SCALE_DEFAULT);
    pausedscreen=readImage("startscreen.png").getScaledInstance (1000, 900, Image.SCALE_DEFAULT);
    creditscreen=readImage("credits.png");
    factscreen1=readImage("fact1.png"); 
    factscreen2=readImage("fact2.png"); 
    factscreen3=readImage("fact3.png"); 
    factscreen4=readImage("fact4.png"); 
    factscreen5=readImage("fact5.png"); 
    factscreen6=readImage("fact6.png"); 

    }
    public void mainLoop()
    {
    while(true)
    {
      if(stoppedx !=true)
      {
        x+=xSpeed/100;//moves the main map
      }
      if(stoppedy !=true)
      {
        y+=ySpeed/100;//moves the main map
      }

        if(leftPressed==true)
        {
          xSpeed+=speed;
        }
        if(rightPressed)
        {
         xSpeed-=speed; 
        }
        if(downPressed)
        {
         ySpeed-=speed;
        }
        if(upPressed)
        {
          ySpeed+=speed;
        }
        if (xSpeed> maxSpeed)
             {
              xSpeed=maxSpeed;
             }
       if ((ySpeed-1)<(-maxSpeed))
                {
                ySpeed= -maxSpeed;
                }
        if ((xSpeed-1)<(-maxSpeed))
                {
                xSpeed= -maxSpeed;
                }
            if (ySpeed> maxSpeed)
                {
                ySpeed=maxSpeed;
                }
            
        if (xSpeed<0)//this segment of code adds friction
        {
         xSpeed+=friction;
        }
        else if (xSpeed>0)
        {
         xSpeed-=friction;
        }
        if (ySpeed<0)
        {
         ySpeed+=friction;
        }
       else if (ySpeed>0)
        {
         ySpeed-=friction;
        }
        
        if (x>maxboundsx-500)//stops the player when it reaches the end of the map
        {
         x=maxboundsx-500;
         playermovex=true;

        }
        if (y>maxboundsy-450)
        {
        y=maxboundsy-450;
        playermovey=true;
        }
        if (y<-maxboundsy+450)
        {
         y=-maxboundsy+450;
        playermovey=true;
        }
        if (x<-maxboundsx+500)
        {
        x=-maxboundsx+500;
        playermovex=true;
        }
        if (playermovex==true)//moves the player sprite when at the edge of the map
        {
          stoppedx=true;
          playerx-=xSpeed/100;
          if (playerx>450 && playerx<500)
          {
            playermovex=false;
            stoppedx=false;
          }
        }
        if (playermovey==true)
        {
          stoppedy=true;
          playery-=ySpeed/100;
          if (playery>350 && playery<400)
          {
            playermovey=false;
            stoppedy=false;  
          }          
        }
        if (playery> 750)
        {
          playery=750;
        }
        if (playerx< 1)
        {
          playerx=1;
        }
        if (playerx>880)
        {
          playerx=880;
        }
        if (playery< 0)
        {
          playery=0;
        }
        

        if (epressed==true)
        {
          if(y<1070 && y>890 && x<90 && x>-135)
          {
            fact1=true;
          }
          if(y<3300 && y>2000 && x<-1800 && x>-2100)
          {
            fact2=true;
          }
          if(y<4300 && y>4000 && x<130 && x>-130)
          {
            fact3=true;
          }
          if(y<-4000 && y>-4300 && x<130 && x>-130)
          {
            fact4=true;
          }
          if(y<2500 && y>2250 && x<2850 && x>2550)
          {
            fact5=true;
          }
          if(y<-890 && y>-1000 && x<90 && x>-135)
          {
            fact6=true;
          }
          
        }
        try {
          Thread.sleep(frame_rate);
      } catch (Exception e) {
      }
    }
    
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
            if (credits==true && startscreen==true)
            {
              g.drawImage(creditscreen,0,0, null);//draws the credits
            }
            if (startscreen==true && credits==false)
            {
              g.drawImage(pausedscreen,0,0, null);//draws the background
            }
            if (startscreen==false && credits==false) 
            { 
            g.drawImage(background, x-5000+500, y-5000+450, null);//draws the background
            g.drawImage(player, playerx, playery, null);//draws the player
             if (fact1==true)
              {
                g.drawImage(factscreen1, 0, 0, null);//draws the facts
              }
              if (fact2==true)
              {
                g.drawImage(factscreen2, 0, 0, null);//draws the facts
              }
              if (fact3==true)
              {
                g.drawImage(factscreen3, 0, 0, null);//draws the facts
              }
              if (fact4==true)
              {
                g.drawImage(factscreen4, 0, 0, null);//draws the facts
              }
              if (fact5==true)
              {
                g.drawImage(factscreen5, 0, 0, null);//draws the facts
              }
              if (fact6==true)
              {
                g.drawImage(factscreen6, 0, 0, null);//draws the facts
              }
            }

        repaint();
    }
    
    public static BufferedImage readImage(String infile)
    {
    try
    {
      BufferedImage ret = ImageIO.read(new File(infile));
      return ret;
    }
    catch(Exception e){System.out.println(e.getMessage()); return null;}
    }
    public void keyPressed(KeyEvent e)//tells if a key is pressed
    {
      int code = e.getKeyCode();
      
      if(code == KeyEvent.VK_RIGHT)
      {
        rightPressed = true;
      }
      else if(code == KeyEvent.VK_LEFT)
      {
        leftPressed = true;
      }
      else if(code == KeyEvent.VK_DOWN)
      {
        downPressed = true;
      }
      else if(code == KeyEvent.VK_UP)
      {
        upPressed = true;
      }
      if(code == KeyEvent.VK_R)
      {
        x=0;
        y=0;
        playerx=450;
        playery=350;
        playermovex=false;
        playermovey=false;
      }
       if(code == KeyEvent.VK_E)
      {
        epressed=true;
      }
       if(code == KeyEvent.VK_G)
      {
        System.out.println("x is "+x+" y is "+y);
      }
    }
    public void keyReleased(KeyEvent e)
    {
      int code = e.getKeyCode();
      
      if(code == KeyEvent.VK_RIGHT)
      {
        rightPressed = false;
      }
      else if(code == KeyEvent.VK_LEFT)
      {
        leftPressed = false;
      }
      else if(code == KeyEvent.VK_UP)
      {
        upPressed = false;
      }
      else if(code == KeyEvent.VK_DOWN)
      {
        downPressed = false;
      }
      if(code == KeyEvent.VK_E)
      {
        epressed=false;
      }
    }
    public void keyTyped(KeyEvent e)
    {
    }
    public void mousePressed(MouseEvent e)//detects is the mouse is pressed
  {
    int button = e.getButton();
    if(button == MouseEvent.BUTTON1)
    {
      xclickloc=e.getX();
      yclickloc=e.getY();
      //tells where the mouse is clicked
    if(xclickloc<620 && xclickloc>340 && yclickloc < 560 && yclickloc > 450)
      {
        credits=true;
      }
      if(xclickloc<670 && xclickloc>300 && yclickloc < 430 && yclickloc > 300)
      {
        startscreen=false;
      }
      if (credits==true && yclickloc<60 && yclickloc>10 && xclickloc<990 && xclickloc>950)
      {
       credits=false;
      }
      if (fact1==true || fact2==true || fact3==true ||fact4==true || fact5==true || fact6==true && yclickloc<60 && yclickloc>10 && xclickloc<990 && xclickloc>950)
      {
       fact1=false;
        fact2=false;
         fact3=false;
          fact4=false;
           fact5=false;
            fact6=false;
      }
    }
  }
  public void mouseReleased(MouseEvent e)
  {
    int button = e.getButton();
    if(button == MouseEvent.BUTTON1);
    {
    }
  }
  public void mouseClicked(MouseEvent e)
  {
  }  
  public void mouseEntered(MouseEvent e)
  { 
  } 
  public void mouseExited(MouseEvent e)
  { 
  } 
}


