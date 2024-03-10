package WindowGame;

import Database.DatabaseClass;
import Objects.Player;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class MouseInput implements MouseListener {


    public Camera cam = new Camera(0,0);
    Handler handler = new Handler(cam);
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImage level = loader.loadImage("Resource/Level-01V1.png");//image loader
    BufferedImage level2 = loader.loadImage("Resource/Level-02V1.png");

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        /*
        g.drawImage(new_game,1080/2 - lungime1,300 ,null);
        g.drawImage(load,1080/2-lungime2,310 + latime1,null);
        g.drawImage(settings,1080/2-lungime3,320 +latime1 + latime2,null);
        g.drawImage(exit,1080/2-lungime4,330 +latime1 + latime2+latime3,null);
         */
        int mx = e.getX();
        int my = e.getY();
        if(Game.State == Game.STATE.MENU) {

            //this is the New Game
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100)) {
                if (my >= 300 && my <= 350) {
                    Game.State = Game.STATE.GAME;
                }
            }
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100) && my >= 360 && my <= 400) {
                /*// Check if a saved game exists
                if (DatabaseClass.savedGameExists()) {
                    // Load the saved game
                    loadSavedGame();
                } else {
                    // Start a new game
                    Game.State = Game.STATE.GAME;
                }*/
                Game.State = Game.STATE.GAME;
            }

            // this is the Exit button
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100)) {
                if (my >= 480 && my <= 530) {
                    System.exit(1);
                }
            }

            // this is the Info button
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100)) {
                if (my >= 415 && my <= 465) {
                    Game.State=Game.STATE.INFO;
                }
            }
        }
        if(Game.State == Game.STATE.PlayedMainMenu) {
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100)) {
                if (my >= 300 && my <= 350) {
                    Game.State = Game.STATE.GAME;
                }
            }
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100)) {
                if (my >= 480 && my <= 530) {
                    System.exit(1);
                }
            }
            if (mx >= (1080 / 2 - 100) && mx <= (1080 / 2 + 100)) {
                if (my >= 415 && my <= 465) {
                    Game.State=Game.STATE.INFO;
                }
            }
        }
        else if(Game.State == Game.STATE.PAUSED)
        {
            if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=250 && my<= (250+75))
                {
                     Game.State = Game.STATE.PlayedMainMenu;
                }
            }
            if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=425 && my<= (425+75))
                {
                    System.exit(1);
                }
            }
            /*if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=530 && my<= (550))
                {
                    //DatabaseClass.savePlayerPosition(DatabaseClass.getPlayerDatabaseHp(),DatabaseClass.getPlayerX(),DatabaseClass.getPlayerY());
                }
            }*/
        }
        else if(Game.State == Game.STATE.INFO)
        {
            if(mx>=100 && mx<=400)
            {
                if(my>=600 && my<=672 )
                {
                    Game.State = Game.STATE.MENU;
                }
            }
        }
        else if(Game.State == Game.STATE.GameOver)
        {
            if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=250 && my<= (250+75))
                {

                    Game.State = Game.STATE.MENU;
                   /* Game.Level =0 ;
                    handler.LoadImageLevel(level);
                    handler.switchLevel();*/
                }
            }
            if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=425 && my<= (425+75))
                {
                    System.exit(1);
                }
            }
        }
        else if(Game.State == Game.STATE.WinGame)
        {
            if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=250 && my<= (250+75))
                {

                    Game.State = Game.STATE.MENU;
                   /* Game.Level =0 ;
                    handler.LoadImageLevel(level);
                    handler.switchLevel();*/
                }
            }
            if(mx >= (1080/2 - 200) && mx<=(1080/2 + 200))
            {
                if(my >=425 && my<= (425+75))
                {
                    System.exit(1);
                }
            }
        }
    }

    private void loadSavedGame() {
        Game.State = Game.STATE.GAME;
        // Set the player's data in the game
        //DatabaseClass.setPlayerHealth(DatabaseClass.getPlayerDatabaseHp());
        //DatabaseClass.setPlayerPosition(DatabaseClass.getPlayerX(),DatabaseClass.getPlayerY());
        // Continue with any additional logic required to resume the game from the saved state
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
