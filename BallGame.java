import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/**
<applet code = "BallGame.class" width = 1000 height = 405>
</applet>
*/

public class BallGame extends Applet implements KeyListener,Runnable
{
boolean hit,jump;
int rx=900,ry=350,bx=100,by=380,dir,bg;
String str="";
String score="score : 0";
int scr;
Font f = new Font("Times New Roman",Font.ITALIC,50);
Font f2 = new Font("Ariel",Font.ITALIC,25);

                                               public void init()
                                               {
                                               Thread t = new Thread(this);
                                               t.start();
                                               addKeyListener(this);
                                               }

public void keyPressed(KeyEvent ke)
{
if (ke.getKeyCode() == KeyEvent.VK_SPACE)
{
jump=true;
}
}

public void keyReleased(KeyEvent ke){}
public void keyTyped(KeyEvent ke){}



public void run()
{
while(!hit)
{
try
{
rx=rx-4;                                       //speed
Thread.sleep(10);
if(((bx+12)>rx)&&(bx<(rx+10))&&(by+10)>ry)
{
hit=true;
str="Game Over";
}
            if(jump)
            {
            if((dir%2)==0)
            by=by-3;                           //gravity
            if(by<=305)                        //ball jump height
            dir++;
                     if(dir!=0&&by>=385)       //ground
                     {
                     dir++;
                     jump=false;
                     scr++;
                     if(scr%10==0)
                     bg++;
                     } 
            if((dir%2)!=0)
            by=by+3;
            } 
if(rx<=0)
rx=1000;
score="score : "+scr;
repaint();          
}           
catch(InterruptedException ie){}
}         
}


public void paint(Graphics g)
{
g.setColor(Color.BLACK);
g.drawLine(0,400,1000,400);
g.fillRect(rx,ry,10,50);
g.setFont(f);
g.drawString(str,400,200);
g.setFont(f2);
g.drawString(score,800,50);
g.setColor(Color.RED);
g.fillOval(bx,by,15,15);
if((bg)%2==0)
setBackground(Color.PINK);
else
setBackground(Color.YELLOW);

}
}



