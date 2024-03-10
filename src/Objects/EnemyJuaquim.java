package Objects;
import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Animation;
import WindowGame.Game;
import WindowGame.Handler;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class EnemyJuaquim extends GameObject {
    private float velocity ;
    private Handler handler;
    private int enemy_facing;
    Animation JuaquimWalk, JuaquimWalkLeft;
    Texture texture = Game.getInstance();
    private boolean movingRight;
    public int Juaquim_hp=3;


    public EnemyJuaquim(float x, float y, ObjectID ID, Handler handler,int hp) {
        super(x, y, ID);
        this.handler= handler;
        this.Juaquim_hp = hp;
        velocity = 3.0f;
        movingRight = true;

        JuaquimWalkLeft = new Animation(5,false,texture.juaquim_vector[0],texture.juaquim_vector[1],texture.juaquim_vector[2],texture.juaquim_vector[3],texture.juaquim_vector[4]);
        JuaquimWalk = new Animation(5,false,texture.juaquim_vector[5],texture.juaquim_vector[6],texture.juaquim_vector[7],texture.juaquim_vector[8],texture.juaquim_vector[9] );


    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        x+=velocity;
        if(velocity < 0)
            enemy_facing = -1;
        else
            enemy_facing = 1;

        collision(object);
        JuaquimWalk.runAniamtion();
        JuaquimWalkLeft.runAniamtion();

    }

    protected void collision(LinkedList<GameObject> object) {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ObjectID.Block_2) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if (movingRight) {
                        velocity = -5;
                        x += velocity ; // Align with the left side of the block
                        movingRight = false;
                        //Handler.databaseLoad.saveEnemyPosition(x,y,1);
                    } else {
                        velocity = 5;
                        x += velocity; // Align with the right side of the block
                        movingRight = true;
                        //Handler.databaseLoad.saveEnemyPosition(x,y,1);
                    }
                }
            }
        }
    }


    @Override
    public void render(Graphics graphic) {
        // Render the enemy
        /*graphic.setColor(Color.red);
        graphic.fillRect((int) x, (int) y, 96, 128);*/
        if(walking)
        {
            if(enemy_facing == 1 )
                JuaquimWalk.drawAnimation(graphic,(int)x,(int)y);
            else JuaquimWalkLeft.drawAnimation(graphic,(int)x,(int)y);
        }

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 96, 128);
    }
    public void decreaseHp()
    {
        Juaquim_hp -=1;
    }
    public void decreaseHpAmount(int hp)
    {
        Juaquim_hp -= hp;
    }
    public int getJuaquim_hp(){return Juaquim_hp;}

}



