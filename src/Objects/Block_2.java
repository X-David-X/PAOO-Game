package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;

import java.awt.*;
import java.util.LinkedList;

public class Block_2 extends GameObject {

    Texture texture= Game.getInstance();
    private int width =64,heigth =64;

    private int type;

    public Block_2(float x, float y, int type , ObjectID ID) {
        super(x, y, ID);
        this.type=type;

    }

    public void tick(LinkedList<GameObject> object) {

    }
    @Override
    public void render(Graphics g)
    {
        if(type == 0)//dirt;
            g.drawImage(texture.block_doi[0],(int)x,(int)y,null);
        if(type == 1)//cement;
            g.drawImage(texture.block_doi[1],(int)x,(int)y,null);
        if(type == 2)//brick;
            g.drawImage(texture.block_doi[2],(int)x,(int)y,null);
        if(type == 3)//grinda;
            g.drawImage(texture.block_doi[3],(int)x,(int)y,null);
        if(type == 4)//sky;
            g.drawImage(texture.block_doi[4],(int)x,(int)y,null);
        if(type == 5)//fence_base;
            g.drawImage(texture.block_doi[5],(int)x,(int)y,null);
        if(type == 6)//fance_upper;
            g.drawImage(texture.block_doi[6],(int)x,(int)y,null);
        if(type == 7)//solid acoperis;
            g.drawImage(texture.block_doi[7],(int)x,(int)y,null);
        if(type == 8)//scara acoperis;
            g.drawImage(texture.block_doi[8],(int)x,(int)y,null);
        if(type == 9)//geam;
            g.drawImage(texture.block_doi[9],(int)x,(int)y,null);
        if(type == 10)//block nebun;
            g.drawImage(texture.block_doi[10],(int)x,(int)y,null);
        if(type == 11)//stalp gros
            g.drawImage(texture.block_doi[11],(int)x,(int)y,null);
        if(type == 12)//gerd fier
            g.drawImage(texture.block_doi[12],(int)x,(int)y,null);
        if(type == 13)//baza_fier
            g.drawImage(texture.block_doi[13],(int)x,(int)y,null);
        if(type == 14)//baza_fier
            g.drawImage(texture.block_doi[14],(int)x,(int)y,null);
        if(type == 15)//usa
            g.drawImage(texture.block_doi[15],(int)x,(int)y,null);
        if(type == 16)//stalp-curba
            g.drawImage(texture.block_doi[16],(int)x,(int)y,null);
        if(type == 17)//invisible no collision block
        {
            g.setColor(new Color(255, 255, 0, 0));
            g.drawRect((int)this.x, (int) this.y, 64, 64);
        }

    }

    public Rectangle getBounds() {
        //return null;
       return new Rectangle((int)x,(int)y,64,64);
    }
    public  Rectangle getEnemyBounds()
    {
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
    public int getWidth()
    {
        return width;
    }
    public int getHeigth(){ return heigth;}

}

