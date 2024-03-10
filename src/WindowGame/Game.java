package WindowGame;

import Framework.KeyInput;
import Framework.ObjectID;
import java.awt.*;

import Framework.Texture;
import Objects.*;
import WindowGame.UI.*;
import WindowGame.UI.Menu;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.*;

public class Game extends Canvas implements Serializable,Runnable{

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public enum STATE{
        MENU, GAME, PAUSED, INFO,PlayedMainMenu,GameOver,WinGame
    }
    public static STATE State = STATE.MENU;
    private static final long serialVersionUID = -7081442766650643L;
    private boolean running = false;
    public static int WIDTH,HEIGHT;
    WindowGame.UI.Menu menu = new Menu() ;
    PauseMenu paused = new PauseMenu();
    InfoMenu info =new InfoMenu();
    GameOVer gameOver = new GameOVer();
    PlayedBeforeMainMenu playedMenu = new PlayedBeforeMainMenu();
    WinGame win = new WinGame();

    public Camera cam;
    Handler handler;
    static Texture texture;
    public static int Level = 0;

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public BufferedImage level = null, background = null, backgr2=null,bckgr3=null;
    private void init()
    {

        WIDTH=getWidth();
        HEIGHT=getHeight();
        texture = new Texture();
        BufferedImageLoader loader = new BufferedImageLoader();
        level = loader.loadImage("Resource/Level-01V1.png");//image loader
        background = loader.loadImage("Resource/City background.png");
        backgr2 = loader.loadImage("Resource/2017-04-18-20-27-19_1080x720.jpg");
        bckgr3 = loader.loadImage("Resource/Eric_Room_1080x720.png");



        cam = new Camera(0,0);
        handler = new Handler(cam);


        //handler.CreateLevel();
        handler.LoadImageLevel(level);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput());

    }

    public synchronized void start()
    {
        if(running)     //metoda pentru a impiedica deschidearea a unui now thread, in cazul in care s-ar deschide mai multe
            return;

        running =true;
        Thread thread = new Thread(this);
        thread.start();

    }


    public void run()
    {
        init();
        this.requestFocus();
        long lastTime= System.nanoTime();
        double FPS = 60;
        double ns = 1000000000/FPS;
        double delta =0;
        while(running)
        {
            long now = System.nanoTime();
            delta+=(now - lastTime)/ns;
            lastTime=now;
            if(delta>=1)
            {
                tick();
                render();
                delta--;
            }


        }
    }

    private void tick()
    {

       if(State == STATE.GAME)
        {
            handler.tick();
            for (int i = 0; i < handler.object.size(); i++) {
                if (handler.object.get(i).getID() == ObjectID.Player) {
                    cam.tick(handler.object.get(i));
                }
            }

        }

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;

        //Draw objects
        if(State == STATE.GAME)
        {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
            if(Game.Level==1)
            {
                g.drawImage(backgr2,0,0,getWidth(),getHeight(),null);
            }
            if(Game.Level == 2)
            {
                g.drawImage(bckgr3,0,0,getWidth(),getHeight(),null);
            }
            //follow camera
            g2d.translate(cam.getX(), cam.getY());              //inceputul camerei, ceea ce randeaza camera
            handler.render(g);

            // enemy_handler.render(g);
            //follow camera
            g2d.translate(-cam.getX(), -cam.getY());            //finalul camerei, ce randeaza camera
            Font fnt1= new Font("Arial",Font.ITALIC,25);
            g.setFont(fnt1);
            g.setColor(new Color(190, 200,240,100));
            g.fillRect(1080/8-125,230,260,70);
            g.setColor(new Color(0,0,0));
            g.drawString("Score: "+ Player.score,1080/8 -120,280);


            Font fnt7= new Font("Algerian",Font.BOLD,30);
            g.setFont(fnt7);
            g.setColor(new Color(100,10,240,150));
            g.fillRect(25,5,210,40);
            g.setColor(new Color(244,56,76));
            g.drawString("Health: "+ Player.hp + "/3",30,30);


            if(Game.Level == 2)
            {
                Font fnt2= new Font("Comic Sans MS",Font.ITALIC,50);
                Font fnt3= new Font("Arial",Font.BOLD,40);
                g.setColor(new Color(217,88,0,240));
                g.setFont(fnt2);
                g.drawString("\\Boss ERICH-Cartman a.k.a Miguel-Placiba //",40,50);
                g.setColor(new Color(10,50,50,170));
                g.fillRect(1080/4+1080/8-60,70,600,100);
                g.setFont(fnt3);
                g.setColor(new Color(40,30,240));
                g.drawString("HpBOSS: " + EricBoss.hp + "/100",1080/4+1080/8-40,140);

            }
         }
        else if(State == STATE.MENU)
        {
            menu.render(g);
        }
        else if(State == STATE.PAUSED)
        {
            paused.render(g);
        }
        else if(State == STATE.INFO)
        {
            info.render(g);
        } else if (State == STATE.PlayedMainMenu) {
            playedMenu.render(g);
        }
        else if (State == STATE.GameOver)
        {
            Player.score = 0;
            Player.database_score.setScore(Player.score);
            gameOver.render(g);
            handler.switchLevel(0);

        }
        else if(State == STATE.WinGame)
        {
            win.render(g);
            handler.switchLevel(0);
        }
        g.dispose();
        bs.show();
    }



    public static Texture getInstance()
    {
        return texture;
    }


    public static void main( String[] args)
    {
        new Window(1080,720,"Jamal The Shaorma Revenge",new Game());

    }

}
