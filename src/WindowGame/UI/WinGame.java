package WindowGame.UI;

import Objects.Player;
import WindowGame.BufferedImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class WinGame {
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImage mainMenu = loader.loadImage("Resource/Main Menu.png");
    BufferedImage Exit = loader.loadImage("Resource/Exit.png");


    public void render(Graphics g)
    {
        g.setColor(new Color(145,35,60));
        g.fillRect(0,0,1080,720);
        g.setColor(new Color(14,250,50,90));
        g.drawRect(1080/4+40,720/4+30,mainMenu.getWidth()+100,mainMenu.getHeight()*5);
        g.fillRect(1080/4+40,720/4+30,mainMenu.getWidth()+100,mainMenu.getHeight()*5);
        g.drawImage(mainMenu,1080/2- mainMenu.getWidth()/2,250,null);
        g.drawImage(Exit,1080/2- Exit.getWidth()/2,300 + 75 + 50,null);
        Font fnt1= new Font("Arial",Font.BOLD,40);
        Font fnt2= new Font("Algerian",Font.BOLD,50);

        g.setColor(new Color(190, 200,240,120));
        g.fillRect(1080/8 -100,20,1020,150);

        g.setFont(fnt2);
        g.setColor(new Color(210,216,10));
        g.drawString("You WON! ",340,80);
        g.drawString("You ve got the Delicious Shawarma",50,140);

        g.setColor(new Color(50,230,170,140));
        g.fillRect(1080/8-125,230,260,70);
        g.setFont(fnt1);
        g.setColor(new Color(0,0,0));
        g.drawString("Score: "+ Player.score,1080/8 -120,280);


    }
}

