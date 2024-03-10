package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;

public class Flag extends GameObject {

    Texture texture= Game.getInstance();
    private Handler handler;
    private int level_gate;

    public Flag(float x, float y, ObjectID ID, int lvl) {

        super(x, y, ID);
        this.level_gate =lvl;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {

    }

    @Override
    public void render(Graphics g) {
      if( level_gate == 1) {
          g.drawImage(texture.block_transport_vect[0], (int) x, (int) y, null);
      }
      if(level_gate == 2) {
          g.drawImage(texture.block_transport_vect[1], (int) x, (int) y, null);
      }

    }

    @Override
    public Rectangle getBounds() {
            return new Rectangle((int)x,(int)y,64,64);
    }

    public int getType()
    {
        return level_gate;
    }
}
