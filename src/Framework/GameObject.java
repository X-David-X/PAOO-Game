package Framework;

import Objects.Player;
import WindowGame.Camera;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;
import java.util.Objects;

public abstract class  GameObject {

    protected float x,y;
    protected ObjectID ID;
    protected float velX=0, velY=0;
    protected boolean walking = true;
    protected boolean falling = true;
    protected boolean jumping = true;
    protected int hp;
    protected int score;
    protected float width,height;


    protected int facing = 1,enemy_facing=1;
    // facing = 1 -> right,
    // facing = -1 -> left
    protected int type;

    public GameObject(float x,float y,ObjectID ID)
    {
        this.x=x;
        this.y=y;
        this.ID=ID;
    }

    public abstract void tick(LinkedList<GameObject> object);
    public abstract void render(Graphics graphic);

    public abstract Rectangle getBounds();

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

    public  ObjectID getID()
    {
        return ID;
    }

    public boolean isFalling() {
        return falling;
    }
    public void setFalling(boolean falling) {
        this.falling = falling;
    }
    public boolean isJumping() {
        return jumping;
    }
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public int getFacing()
    {
        return facing;
    }

    public int getType(){ return type;}
    public Rectangle getEnemyBounds()
    {
        return new Rectangle((int)x,(int)y,64,64);
    }

    public void setSpawn(int x, int y)
    {
        this.x = x*64;
        this.y = y*64;
    }
    public void decreaseHp()
    {
        hp -=1;
    }
    public void decreaseHpAmount(int amount)
    {
        hp -= amount;
    }
    public void decreaseHpBoss(int amount)
    {
        hp -= amount;
    }
    public int getJuaquim_hp(){return 1;}

    public int getPlayerHp()
    {
        return hp;
    }
    public void increaseScore(int amount)
    {
    }
    public Rectangle getBoundsTop() {
        return new Rectangle((int) (x + width/4 ), (int) y, (int)(width / 2), (int)(height / 4));
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) (x + width -width/8), (int) (y + height / 8 - 12), (int)(width /8), (int)(height - height / 8 + 8));
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) (y + height / 8 - 12), (int)(width / 8), (int)(height - height / 6 +16));
    }

}
