package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;

public class CanonBall extends GameObject {
    public static boolean spawned = false;
    private Handler handler;
    Texture texture = Game.getInstance();


    public CanonBall(float x, float y, ObjectID ID, int velX, Handler handler) {
        super(x, y, ID);
        this.velX = velX;
        this.handler = handler;
        spawned = true;
    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x += velX;
        Colllison(object);
    }

    @Override
    public void render(Graphics graphic) {

        graphic.setColor(Color.green);
        graphic.drawImage(texture.canon_bal_vec[0],(int)x,(int)y,null);
        //graphic.fillRect((int)x,(int)y,32,32);

    }

    public static boolean getSpawn()
    {
        return spawned;
    }
    private void Colllison(LinkedList<GameObject>object) {

        boolean isSpawned = CanonBall.getSpawn();
        if(isSpawned) {
            for (int i = 0; i < handler.object.size(); i++) {

                GameObject tempObject = handler.object.get(i);

                if (tempObject.getID() == ObjectID.Block) {

                    if (getBounds().intersects(tempObject.getBounds())) {
                        handler.removeObject(this);
                    }
                }
                if(tempObject.getID() == ObjectID.Player)
                {
                    if (getBounds().intersects(tempObject.getBounds())) {

                        handler.removeObject(this);
                        tempObject.decreaseHpAmount(1);
                    }
                    if (getBounds().intersects(tempObject.getBoundsTop())) {

                        handler.removeObject(this);
                        tempObject.decreaseHpAmount(1);
                    }



                }
            }
        }
    }
    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x,(int)y,32,32);
    }
}
