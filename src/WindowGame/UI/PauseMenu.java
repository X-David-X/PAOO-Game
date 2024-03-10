package WindowGame.UI;

import Objects.Player;
import WindowGame.BufferedImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PauseMenu {
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImage mainMenu = loader.loadImage("Resource/Main Menu.png");
    BufferedImage Exit = loader.loadImage("Resource/Exit.png");

    public void render(Graphics g)
    {
        g.setColor(new Color(14,250,50,40));
        g.drawRect(1080/4+40,720/4+30,mainMenu.getWidth()+100,mainMenu.getHeight()*5);
        g.fillRect(1080/4+40,720/4+30,mainMenu.getWidth()+100,mainMenu.getHeight()*5);
        g.drawImage(mainMenu,1080/2- mainMenu.getWidth()/2,250,null);
        g.drawImage(Exit,1080/2- Exit.getWidth()/2,300 + 75 + 50,null);


        Font fnt1= new Font("Arial",Font.ITALIC,25);
        g.setFont(fnt1);
        g.setColor(new Color(190, 200,240,100));
        g.fillRect(1080/8-125,230,260,70);
        g.setColor(new Color(0,0,0));
        g.drawString("Score: "+ Player.score,1080/8 -120,280);
        g.drawString("Save game ",1080/2- Exit.getWidth()/2,550);
    }
}
