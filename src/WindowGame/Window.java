package WindowGame;


import javax.swing.JFrame;
import java.awt.*;


public class Window
{
     public Window (int w, int h, String title, Game game)
     {
          game.setPreferredSize(new Dimension(w,h));
          game.setMaximumSize(new Dimension(w,h));
          game.setMinimumSize(new Dimension(w,h));


          JFrame jFrame = new JFrame(title);
          jFrame.add(game);
          jFrame.pack();
          jFrame.setDefaultCloseOperation((JFrame.EXIT_ON_CLOSE));
          jFrame.setResizable(false);
          jFrame.setLocationRelativeTo(null);
          jFrame.setVisible(true);

          game.start();
     }

}
