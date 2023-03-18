import java.awt.*;
import java.util.Random;

public class Ball extends Rectangle{
    int xVelocity;
    int yVelocity;
    int initialSpeed=2;

    Random random;
    Ball(int x, int y, int width, int height){
        super(x,y,width, height);
        random=new Random();
        int RandomXDirection= random.nextInt(2);
        if(RandomXDirection==0){
            RandomXDirection--;
        }
        setXDirection(RandomXDirection);
        int RandomYDirection= random.nextInt(2);
        if(RandomYDirection==0){
            RandomYDirection--;
        }
        setYDirection(RandomYDirection);
    }

    public void setXDirection(int RandomXDirection){
        xVelocity= RandomXDirection;
    }

    public void setYDirection(int RandomYDirection){
        yVelocity= RandomYDirection;
    }

    public void move(){
        x+=xVelocity;
        y+=yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x,y,width,height);

        g.drawLine((1000/2),0,(1000/2),555);
    }
}
