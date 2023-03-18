import java.awt.*;

public class Score extends Rectangle {
    int width;
    int height;
    String name1= "Player - 1";
    String name2= "Player - 2";
    int player1;
    int player2;
    Score(int width, int height){
        this.width=width;
        this.height=height;
    }
    public void draw(Graphics g){
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(name1+"  "+String.valueOf(player1), width/2-235,40);
        g.drawString(String.valueOf(player2)+"  "+name2, width/2+15,40);
    }
}
