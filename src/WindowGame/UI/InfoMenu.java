package WindowGame.UI;

import Framework.Texture;
import WindowGame.BufferedImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InfoMenu {

    public void render(Graphics g)
    {
        Texture texture = new Texture();
        BufferedImageLoader loader =new BufferedImageLoader();
        BufferedImage back = loader.loadImage("Resource/Back.png");



        Font fnt1= new Font("Arial",Font.ITALIC,25);
        Font fnt2= new Font("Arial",Font.BOLD,50);

        g.setColor(new Color(44,241,51));
        g.fillRect(0,0,1080,720);
        g.setFont(fnt1);
        g.setColor(new Color(0,0,0));
        g.drawString(" " + "W -> Jump",100,150);
        g.drawString(" " + "D -> Walk Right ",100,200);
        g.drawString(" " + " A -> Walk Left",100,250);
        g.drawString(" " + "Space -> Shoot",100,300);
        g.drawString(" " + "R -> Back to Respawn",100,350);


        g.setFont(fnt2);
        g.setColor(new Color(0,0,0));
        g.drawString("Controls:",50,100);

        g.drawString("Jamal: ",1080 *3/4,150);
        g.drawImage(texture.player[0],1080* 3/4,200,null);
        g.drawImage(back,100,600,null);


    }

}
