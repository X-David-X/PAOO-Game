package WindowGame.UI;

import WindowGame.BufferedImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Menu {
   //BufferedImage menu_image = null, new_game= null, load =null, settings = null,exit =null,jamal=null,shaorma_rev=null;
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImage menu_image = loader.loadImage("Resource/Background_meniu_1080x720.jpg");
    BufferedImage new_game = loader.loadImage("Resource/New_Game_200x50.png");
    BufferedImage load = loader.loadImage("Resource/Load_Game_200x50.png");
    BufferedImage settings = loader.loadImage("Resource/infos_slesh_settings_200x50.png");
    BufferedImage exit = loader.loadImage("Resource/exit_game_200x50.png");
    BufferedImage jamal = loader.loadImage("Resource/Jamal Text.png");
    BufferedImage  shaorma_rev = loader.loadImage("Resource/The_Shaorma_Revenge_800x120.png");

    int lungime1 = new_game.getWidth()/2;
    int lungime2 = load.getWidth()/2;
    int lungime3 = settings.getWidth()/2;
    int lungime4 = exit.getWidth()/2;
    int lungimeJam = jamal.getWidth()/2;
    int lungimeShao = shaorma_rev.getWidth()/2;

    int latime1 = new_game.getHeight();
    int latime2 = load.getHeight();
    int latime3 = settings.getHeight();
    int latime4 =  jamal.getHeight();

    public void render(Graphics g)
    {
        g.drawImage(menu_image,0,0,null);
        g.drawImage(new_game,1080/2 - lungime1,300 ,null);
        g.drawImage(load,1080/2-lungime2,310 + latime1,null);
        g.drawImage(settings,1080/2-lungime3,320 +latime1 + latime2,null);
        g.drawImage(exit,1080/2-lungime4,330 +latime1 + latime2 + latime3,null);
        g.drawImage(jamal,1080/2-lungimeJam,20,null);
        g.drawImage(shaorma_rev,1080/2-lungimeShao,20+latime4,null);



    }

}
