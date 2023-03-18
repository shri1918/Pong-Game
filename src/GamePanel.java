import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

public class GamePanel extends JPanel implements Runnable{
    int width  = 1000;
    int height = (int)(width*0.555);
    Dimension screen_size= new Dimension(width, height);

    int Paddle_Height=100, Paddle_Width=25;

    Paddle paddle1;
    Paddle paddle2;

    int ball_diameter=20;

    Ball ball;

    Thread gameThread;

    Graphics graphics;

    Image image;

    Score score=new Score(width, height);

    GamePanel(){
        newPaddles();
        newBall();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(screen_size);

        gameThread= new Thread(this);
        gameThread.start();
    }

    private void newBall(){
        Random random= new Random();
        ball= new Ball(width/2-ball_diameter/2, random.nextInt(height-ball_diameter), ball_diameter, ball_diameter);

    }

    private void newPaddles(){
        paddle1= new Paddle(0, height/2-Paddle_Height/2, Paddle_Width, Paddle_Height, 1);
        paddle2= new Paddle(width-Paddle_Width, height/2-Paddle_Height/2, Paddle_Width, Paddle_Height, 2);
    }

    public void paint(Graphics g){
        image=createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0,0,this);
    }

    private void draw(Graphics g){
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void run(){
        long lasttime=System.nanoTime();
        double amountOfTicks=60.0;
        double ns= 1000000000/amountOfTicks;
        double delta=0;
        while(true){
            long now= System.nanoTime();
            delta+=(now-lasttime)/ns;
            lasttime=now;
            if(delta>=1){
                move();
                repaint();
                checkCollision();
                delta--;
            }
        }
    }

    private void move(){
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }

    private void checkCollision(){
        if(ball.y<=0){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y>=height-ball_diameter){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.intersects(paddle1)){
            ball.xVelocity=-ball.xVelocity;
            ball.xVelocity++;
            if(ball.yVelocity>0){
                ball.yVelocity++;
            }
            else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)){
            ball.xVelocity=-ball.xVelocity;
            ball.xVelocity--;
            if(ball.yVelocity>0){
                ball.yVelocity++;
            }
            else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(paddle1.y<=0){
            paddle1.y=0;
        }
        if(paddle1.y>=height-Paddle_Height){
            paddle1.y=height-Paddle_Height;
        }
        if(paddle2.y<=0){
            paddle2.y=0;
        }
        if(paddle2.y>=height-Paddle_Height){
            paddle2.y=height-Paddle_Height;
        }

        if(ball.x>=width-ball_diameter){
            newPaddles();
            newBall();
            score.player1++;
        }
        if(ball.x<=0){
            newPaddles();
            newBall();
            score.player2++;
        }
    }
}
