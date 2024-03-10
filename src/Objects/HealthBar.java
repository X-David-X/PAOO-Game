package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;

import java.awt.*;
import java.util.LinkedList;

public class HealthBar extends GameObject {
    public int type;
    Texture texture;
    public HealthBar(float x, float y, int type ,ObjectID ID) {
        super(x, y, ID);
        this.type=type;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics graphic) {

        if(type==0)         // half HP
        {
            graphic.drawImage(texture.hp_vector[0],1000,1000,null );
        }
        if(type==1)         //full HP
        {
            graphic.drawImage(texture.hp_vector[1],0,0,null );
        }
        if(type==2)         // empty Hp
        {
            graphic.drawImage(texture.hp_vector[2],0,0,null );
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
