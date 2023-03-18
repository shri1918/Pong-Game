import java.awt.*;
import java.awt.event.KeyEvent;

public class Paddle extends Rectangle{
    int id;
    int yVelocity;
    int speed=5;
    Paddle(int x, int y, int Paddle_width, int paddle_height, int id){
        super(x,y,Paddle_width, paddle_height);
        this.id= id;
    }

    public void draw(Graphics g){
        if(id==1){
            g.setColor(Color.yellow);
        }
        else{
            g.setColor(Color.red);
        }
        g.fillRect(x,y,width,height);
    }

    public void keyPressed(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-speed);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-speed);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(speed);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                }
                break;
        }
    }

    private void setYDirection(int i){
        yVelocity=i;
    }

    public void move(){
        y=y+yVelocity;
    }
}
