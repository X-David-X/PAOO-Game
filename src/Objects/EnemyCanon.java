package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Animation;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;

public class EnemyCanon extends GameObject {

    private Handler handler;
    private int enemy_facing;
    Texture texture = Game.getInstance();
    Animation Canon_shoot_right,Canon_shoot_left;
    private long lastSummonTime;
    private boolean canSummonCanonball;
    private int canonballsShot;
    private long lastReloadTime;


    public EnemyCanon(float x, float y, ObjectID ID, Handler handler,int facing) {
        super(x, y, ID);
        this.handler= handler;
        this.enemy_facing = facing;
        lastSummonTime = System.currentTimeMillis(); // Initialize the lastSummonTime with the current time
        canSummonCanonball = true;
        Canon_shoot_right = new Animation(10,true,texture.canon_vec[0],  texture.canon_vec[1],texture.canon_vec[2],texture.canon_vec[3] );
        Canon_shoot_left = new Animation(10,true,texture.canon_vec[4],  texture.canon_vec[6],texture.canon_vec[5],texture.canon_vec[7]);
    }



   /* public void tick(LinkedList<GameObject> object) {
        Canon_shoot_left.runAniamtion();
        Canon_shoot_right.runAniamtion();

        long currentTime = System.currentTimeMillis();
        long timeSinceLastSummon = currentTime - lastSummonTime;
        if (timeSinceLastSummon >= 8000) {
            canSummonCanonball = true; // Enable canonball summoning
        }
    }
    public void render(Graphics graphic) {
        if (enemy_facing == 1) {
            Canon_shoot_left.drawAnimation(graphic, (int) x, (int) y);
        } else if (enemy_facing == -1) {
            Canon_shoot_right.drawAnimation(graphic, (int) x, (int) y);
        }

        if (canSummonCanonball) {
            // Summon the canonball at the desired position
            handler.addObject(new CanonBall((int) 97 * 64, (int) 15 * 64, ObjectID.Canon_Ball, -2, handler));
            handler.addObject(new CanonBall((int) 20 * 64, (int) 24 * 64, ObjectID.Canon_Ball, 2, handler));

            canSummonCanonball = false; // Disable canonball summoning until enough time passes again
            lastSummonTime = System.currentTimeMillis(); // Update the last summon time
        }
    }*/


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        // This from below is the shoot
    ////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void tick(LinkedList<GameObject> object) {
        Canon_shoot_left.runAniamtion();
        Canon_shoot_right.runAniamtion();

        long currentTime = System.currentTimeMillis();
        long timeSinceLastReload = currentTime - lastReloadTime;

        if (canonballsShot >= 4 && timeSinceLastReload >= 10000) {
            canonballsShot = 0; // Reset the number of canonballs shot
            lastReloadTime = currentTime; // Update the last reload time
        }

        long timeSinceLastSummon = currentTime - lastSummonTime;

        if (!canSummonCanonball && canonballsShot < 4 && timeSinceLastSummon >= 10000) {
            canSummonCanonball = true; // Enable canonball summoning
        }
    }

    @Override
    public void render(Graphics graphic) {
        if (enemy_facing == 1) {
            Canon_shoot_left.drawAnimation(graphic, (int) x, (int) y);
        } else if (enemy_facing == -1) {
            Canon_shoot_right.drawAnimation(graphic, (int) x, (int) y);
        }

        if (canSummonCanonball && canonballsShot < 4) {
            // Summon a single canonball
            if (enemy_facing == 1) {
                handler.addObject(new CanonBall((int) x, (int) y, ObjectID.Canon_Ball, -6, handler));
            } else if (enemy_facing == -1) {
                handler.addObject(new CanonBall((int) x, (int) y, ObjectID.Canon_Ball, 6, handler));
            }

            canonballsShot++; // Increment the number of canonballs shot
            canSummonCanonball = false; // Disable canonball summoning until enough time passes again
            lastSummonTime = System.currentTimeMillis(); // Update the last summon time
        }
    }



    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 128);
    }


    public float getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }

    public void setX(float x)
    {
        this.x=x;
    }
    public void sety(float y)
    {
        this.y=y;
    }
    public float getVelX()
    {
        return velX;
    }
    public float getVelY()
    {
        return velY;
    }
    public void setVelX(float velX)
    {
        this.velX=velX;
    }
    public void setVelY(float velY)
    {
        this.velY=velY;
    }
}
