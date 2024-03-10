package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;

public class Bullet extends GameObject {

    public static boolean spawned = false;
    private Handler handler;
    Texture texture = Game.getInstance();
    private int bulletCount;
    private final int MAX_BULLETS = 40;
    private final int RELOAD_TIME = 1000; // time in milliseconds
    private int hit_enemy =0;
    private int type;

    public Bullet(float x, float y, ObjectID ID,int velX, Handler handler,int type) {
        super(x, y, ID);
        this.velX = velX;
        this.bulletCount = MAX_BULLETS;
        this.handler = handler;
        this.type=type;
        spawned = true;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        Colllison(object);
    }

    @Override
    public void render(Graphics graphic) {

        if(type==1)
            graphic.drawImage(texture.bullet[0],(int)x,(int)y,null);
        if(type==2)
            graphic.drawImage(texture.bullet[1],(int)x,(int)y,null);

    }

    public static boolean getSpawn()
    {
        return spawned;
    }
    private void Colllison(LinkedList<GameObject>object) {

        boolean isSpawned = Bullet.getSpawn();
        if(isSpawned) {
            for (int i = 0; i < handler.object.size(); i++) {

                GameObject tempObject = handler.object.get(i);

                if (tempObject.getID() == ObjectID.Block) {

                    if (getBounds().intersects(tempObject.getBounds())) {
                        handler.removeObject(this);
                    }
                }
                if(tempObject.getID() == ObjectID.EnemyJuaquim)
                {
                    if (getBounds().intersects(tempObject.getBounds())) {

                        handler.removeObject(this);
                        tempObject.decreaseHp();
                        if(tempObject.getJuaquim_hp() == 0)
                        {
                            handler.removeObject(tempObject);
                            Player.score+=1000;
                            Player.database_score.setScore(Player.score);
                            tempObject.decreaseHp();
                        }
                    }
                }
                if(tempObject.getID() == ObjectID.Eric_Boss)
                {
                    if(getBounds().intersects(tempObject.getBounds()))
                    {
                        tempObject.decreaseHpBoss(Player.damage_bullet);
                        handler.removeObject(this);
                    }
                }
            }
        }
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,16,16);
    }
}
