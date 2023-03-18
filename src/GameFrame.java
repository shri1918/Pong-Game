import java.awt.Color;

import javax.swing.*;

public class GameFrame {
    JFrame frame;
    GamePanel panel;
    GameFrame(){
        frame= new JFrame("PONG GAME");
        // frame.setLayout(null);
        // frame.setLocationRelativeTo(null));
        panel=new GamePanel();
        // panel.setBounds(0,0,1000,555);
        frame.setBackground(Color.black);
        frame.add(panel);
        // frame.pack();
        frame.setBounds(175, 93, 1016, 594);
        // frame.setSize(1016, 594);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
