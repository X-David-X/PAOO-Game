package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;

public class Block extends GameObject {

    Texture texture= Game.getInstance();
    private Handler handler;
    protected int type;

    public Block(float x, float y,int type , ObjectID ID) {
        super(x, y, ID);
        this.type=type;

    }

    public void tick(LinkedList<GameObject> object) {
    }
    @Override
    public void render(Graphics g)
    {
        if(type == 0)//dirt;
            g.drawImage(texture.block[0],(int)x,(int)y,null);
        if(type == 1)//cement;
            g.drawImage(texture.block[1],(int)x,(int)y,null);
        if(type == 2)//brick;
            g.drawImage(texture.block[2],(int)x,(int)y,null);
        if(type == 3)//grinda;
            g.drawImage(texture.block[3],(int)x,(int)y,null);
        if(type == 4)//sky;
            g.drawImage(texture.block[4],(int)x,(int)y,null);
        if(type == 5)//fence_base;
            g.drawImage(texture.block[5],(int)x,(int)y,null);
        if(type == 6)//fance_upper;
            g.drawImage(texture.block[6],(int)x,(int)y,null);
        if(type == 7)//solid acoperis;
            g.drawImage(texture.block[7],(int)x,(int)y,null);
        if(type == 8)//scara acoperis;
            g.drawImage(texture.block[8],(int)x,(int)y,null);
        if(type == 9)//geam;
            g.drawImage(texture.block[9],(int)x,(int)y,null);
        if(type == 10)//geam;
            g.drawImage(texture.block[10],(int)x,(int)y,null);
        if(type == 11)//block nebun;
            g.drawImage(texture.block[11],(int)x,(int)y,null);
        if(type == 12)//block nebun;
            g.drawImage(texture.block[12],(int)x,(int)y,null);
        if(type == 13)//block nebun;
            g.drawImage(texture.block[13],(int)x,(int)y,null);
        if(type == 14)//block nebun;
            g.drawImage(texture.block[14],(int)x,(int)y,null);
        if(type == 15)//block nebun;
            g.drawImage(texture.block[15],(int)x,(int)y,null);
        if(type == 16)//block nebun;
            g.drawImage(texture.block[16],(int)x,(int)y,null);
        if(type == 17)//
            g.drawImage(texture.block[17],(int)x,(int)y,null);




    }



    public Rectangle getBounds() {
            return new Rectangle((int)x,(int)y,64,64);
        }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x=x;
    }

    public void sety(float y) {
        this.y=y;
    }

    public float getVelX() {
        return velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelX(float velX) {
        this.velX=velX;
    }
    public void setVelY(float velY) {
    this.velY=velY;
    }
    public ObjectID getID() {
        return ID;
    }
    public int getType(){return type;}




}

