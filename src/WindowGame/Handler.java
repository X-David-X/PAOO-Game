package WindowGame;

import Database.DatabaseClass;
import Framework.GameObject;
import Framework.Enemies;
import Framework.ObjectID;
import Objects.*;
import WindowGame.UI.GameOVer;

import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Handler {

    public LinkedList<GameObject> object = new LinkedList<GameObject>();
    private GameObject tempObject;
    private Camera cam;
    BufferedImageLoader loader = new BufferedImageLoader();
    BufferedImage level = loader.loadImage("Resource/Level-01V1.png");//image loader
    BufferedImage level2 = loader.loadImage("Resource/Level-02V1.png");
    BufferedImage level3 = loader.loadImage("Resource/Level-03V1.png");
    public static DatabaseClass databaseLoad = new DatabaseClass();

    public Handler(Camera cam)
    {
        this.cam =cam;
        //databaseLoad.create_table_for_Load();
    }


    public void tick()
    {

        if(Game.Level == 1)
        {
            Player.ResetInstance();
        }
         if(Game.Level == 2)
        {
            Player.ResetInstance();
        }
        for (int i=0;i<object.size();i++)
        {
            tempObject = object.get(i);
            tempObject.tick(object);
            /*if (tempObject instanceof Player)
            {
                Player player = (Player) tempObject;
                databaseLoad.savePlayerPosition(player.getPlayerHp(),player.getX(), player.getY());
            }
            else if (tempObject instanceof EnemyJuaquim)
            {
                EnemyJuaquim enemy = (EnemyJuaquim) tempObject;
               // databaseLoad.saveEnemyPosition(enemy.getX(), enemy.getY(), 1);
            }*/
        }
    }

    public void render(Graphics g)
    {

        for (int i=0;i<object.size();i++)
        {
            tempObject = object.get(i);
            tempObject.render(g);
        }
        Font fnt1= new Font("Arial",Font.ITALIC,25);
        g.setFont(fnt1);
        g.setColor(new Color(190, 200,240,100));
        g.fillRect(50,100,60,110);
        g.setColor(new Color(0,0,0));
        g.drawString("Score"+ Player.score,50,100);

    }
    public void addObject(GameObject object)
    {
        this.object.add(object);
    }
    public void removeObject(GameObject object)
    {
        this.object.remove(object);
    }
    private  void clearLevel()
    {
        object.clear();
    }

    public void switchLevel(int lvl)
    {
        clearLevel();
        Game.Level = lvl;
        cam.setX(0);
        switch (Game.Level)
        {
            case 0:
                LoadImageLevel(level);
                break;
            case 1:
                Player.ResetInstance();
                LoadImageLevel(level2);
                break;
            case 2:
                LoadImageLevel(level3);
                break;

        }
    }
    public void LoadImageLevel(BufferedImage image) {

        int w = image.getWidth();
        int h = image.getHeight();
        //Entities color: ->
        Color playerColor = new Color(85, 255, 0);
        Color enemy = new Color(0, 25, 0);
        Color enemy_canon = new Color(0,35,0);
        Color enemy_canon_2 = new Color(0,55,0);

        Color eric_c = new Color(166,166,166);

        //Block colors: ->
        Color dirtBlockColor = new Color(255, 255, 255);
        Color cementDirtBlockColor = new Color(172, 50, 50);
        Color BricksWall = new Color(63, 63, 116);
        Color Grinda = new Color(255, 0, 0);
        Color Skyie = new Color(99, 155, 255);
        Color fence_base = new Color(207, 140, 73);
        Color fance_up = new Color(149, 102, 55);
        Color acoperis_block = new Color(220, 0, 255); //acopris solid
        Color acoperis_scari = new Color(240, 0, 255); // scara acop
        Color geam = new Color(231, 0, 255); // geam
        Color invi_block = new Color(50,50,50);
        Color block_trans = new Color(40,0,80);
        Color block_spre_vl3 = new Color(50,0,80);
        Color tepi = new Color(102,10,10);
        Color gogoasa = new Color(188,157,241);
        Color m4a1 = new Color(170,170,170);

        // Color
        //color for bck_blocks:
        Color cement_nocol = new Color(255, 0, 255);
        Color stalp_baza_nocol = new Color(50, 189, 94);
        Color stalp_baza_fier_nocol = new Color(38, 189, 83);
        Color gard_fier = new Color(19, 189, 70);
        Color stalp_curba = new Color(50, 190, 94);
        Color geam_nocol3 = new Color(230, 0, 255); // geam
        Color grinda_fier_nocol = new Color(240, 0, 0);
        Color sarma_fier = new Color(66, 58, 58);
        Color cement_casa = new Color(255, 1, 255);
        Color usa = new Color(210, 0, 255);
        Color bck_ciment_lv2 = new Color(240,240,120);
        Color bck_dirt_lv2 = new Color(240,240,130);
        Color tricky_door = new Color(60,60,120);




        //Object colors: ->
        Color pistol = new Color(169, 169, 169);
        Color burger = new Color(33, 33, 33);

        for (int xx = 0; xx < image.getWidth(); xx++) {
            for (int yy = 0; yy < image.getHeight(); yy++) {
                Color pixelColor = new Color(image.getRGB(xx, yy));


                Player player_spawn = Player.GetInstance(xx * 64, yy * 64, 3 ,this, ObjectID.Player,cam);

                // Collision blocks
                if (pixelColor.equals(dirtBlockColor)) {
                    addObject(new Block(xx * 64, yy * 64, 0, ObjectID.Block));
                }
                if (pixelColor.equals(cementDirtBlockColor)) {

                    addObject(new Block(xx * 64, yy * 64, 1, ObjectID.Block));
                }
                if (pixelColor.equals(BricksWall)) {

                    addObject(new Block(xx * 64, yy * 64, 2, ObjectID.Block));
                }
                if (pixelColor.equals(Grinda)) {

                    addObject(new Block(xx * 64, yy * 64, 3, ObjectID.Block));
                }
                if (pixelColor.equals(Skyie)) {

                    addObject(new Block(xx * 64, yy * 64, 4, ObjectID.Block));
                }
                if (pixelColor.equals(fence_base)) {

                    addObject(new Block(xx * 64, yy * 64, 5, ObjectID.Block));
                }
                if (pixelColor.equals(fance_up)) {

                    addObject(new Block(xx * 64, yy * 64, 6, ObjectID.Block));
                }
                if (pixelColor.equals(acoperis_block)) {

                    addObject(new Block(xx * 64, yy * 64, 7, ObjectID.Block));
                }
                if (pixelColor.equals(acoperis_scari)) {

                    addObject(new Block(xx * 64, yy * 64, 8, ObjectID.Block));
                }
                if (pixelColor.equals(stalp_baza_fier_nocol)) {

                    addObject(new Block(xx * 64, yy * 64, 13, ObjectID.Block));
                }
                if (pixelColor.equals(geam)) {

                    addObject(new Block(xx * 64, yy * 64, 9, ObjectID.Block));
                }
                if (pixelColor.equals(cement_casa)) {

                    addObject(new Block(xx * 64, yy * 64, 10, ObjectID.Block));
                }
                if (pixelColor.equals(invi_block)) {

                    addObject(new Block_2(xx * 64, yy * 64, 17, ObjectID.Block_2));
                }
                if (pixelColor.equals(block_trans)) {

                   addObject(new Flag(xx * 64, yy * 64,ObjectID.Flag,1));
                }
                if (pixelColor.equals(block_spre_vl3)) {
                    addObject(new Flag(xx * 64, yy * 64, ObjectID.Flag,2));
                }
                if (pixelColor.equals(tepi)) {

                    addObject(new Block(xx * 64, yy * 64, 17,ObjectID.Block));
                }





                //checks for non-collision blocks
                //
                if (pixelColor.equals(cement_nocol)) {
                   addObject(new Block_2(xx * 64, yy * 64, 10, ObjectID.Block_2));
                }
                if (pixelColor.equals(geam_nocol3)) {

                  addObject(new Block_2(xx * 64, yy * 64, 9, ObjectID.Block_2));
                }
                if (pixelColor.equals(stalp_baza_nocol)) {

                   addObject(new Block_2(xx * 64, yy * 64, 11, ObjectID.Block_2));
                }
                if (pixelColor.equals(gard_fier)) {

                   addObject(new Block_2(xx * 64, yy * 64, 12, ObjectID.Block_2));
                }
                if (pixelColor.equals(grinda_fier_nocol)) {

                    addObject(new Block_2(xx * 64, yy * 64, 3, ObjectID.Block_2));
                }
                if (pixelColor.equals(sarma_fier)) {

                    addObject(new Block_2(xx * 64, yy * 64, 14, ObjectID.Block_2));
                }
                if (pixelColor.equals(usa)) {

                    addObject(new Block_2(xx * 64, yy * 64, 15, ObjectID.Block_2));
                }
                if (pixelColor.equals(stalp_curba)) {

                   addObject(new Block_2(xx * 64, yy * 64, 16, ObjectID.Block_2));
                }
                if (pixelColor.equals(bck_ciment_lv2)) {

                    addObject(new Block_2(xx * 64, yy * 64, 2, ObjectID.Block_2));
                }
                if (pixelColor.equals(bck_dirt_lv2)) {

                    addObject(new Block_2(xx * 64, yy * 64, 0, ObjectID.Block_2));
                }
                if (pixelColor.equals(tricky_door)) {

                    addObject(new Block_2(xx * 64, yy * 64, 2, ObjectID.Block_2));
                }


                //Object checkers:

                if (pixelColor.equals(pistol)) {
                   addObject(new Pickable(xx * 64, yy * 64, 1, ObjectID.Pickable));
                }
                if (pixelColor.equals(burger)) {
                    addObject(new Pickable(xx * 64, yy * 64, 0, ObjectID.Pickable));
                }
                if (pixelColor.equals(gogoasa)) {
                    addObject(new Pickable(xx * 64, yy * 64, 2,ObjectID.Pickable));
                }
                if (pixelColor.equals(m4a1)) {
                    addObject(new Pickable(xx * 64, yy * 64, 3,ObjectID.Pickable));
                }


                //Draw the Player
                if (pixelColor.equals(playerColor)) {
                    addObject(player_spawn);
                }
                /*if (pixelColor.equals(playerColor)) {
                    addObject(new Player(xx * 64, yy * 64, 3 ,this, ObjectID.Player,cam));
                }*/
                //Draw enemies:aa
                if (pixelColor.equals(enemy)) {
                    addObject(new EnemyJuaquim(xx*64,yy*64,ObjectID.EnemyJuaquim,this,3));
                }
                if (pixelColor.equals(enemy_canon)) {
                    addObject(new EnemyCanon(xx*64,yy*64,ObjectID.Canon,this,1));
                }
                if (pixelColor.equals(enemy_canon_2)) {
                    addObject(new EnemyCanon(xx*64,yy*64,ObjectID.Canon,this,-1));
                }
                if (pixelColor.equals(eric_c)) {
                    addObject(new EricBoss(xx * 64, yy * 64,ObjectID.Eric_Boss,this));

                }

            }
        }

    }

}
