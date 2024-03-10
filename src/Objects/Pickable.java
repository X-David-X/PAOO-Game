package Objects;
import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;

import java.awt.*;
import java.util.LinkedList;

public class Pickable extends GameObject {

    Texture texture= Game.getInstance();
    private int type;
    public Pickable(float x, float y,int type, ObjectID ID) {
        super(x, y, ID);
        this.type=type;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
    }

    @Override
    public void render(Graphics graphic) {
        if(type==0)             // for burgir obj
        {
            graphic.drawImage(texture.pickable_obj[0],(int)x,(int)y,null);
        }
        if(type==1)             // for pistol
        {
            graphic.drawImage(texture.pickable_obj[1],(int)x,(int)y,null);
        }
        if(type == 2)
        {
            graphic.drawImage(texture.gogoasa_vec[0],(int)x,(int)y,null);
        }
        if(type == 3)
        {
            graphic.drawImage(texture.mitraliera[0],(int)x,(int)y,null);
        }
    }
    @Override

    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,64,64);
        //return null;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public int getType(){return type;}

}
