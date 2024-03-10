package Objects;

import Framework.Enemies;
import Framework.GameObject;
import Framework.Texture;
import WindowGame.Animation;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.util.LinkedList;

public abstract class EnemyFactory extends Enemies {
    protected static int type;
    public EnemyFactory(float x, float y) {
        super(x, y);
    }

    @Override
    public void tick(LinkedList<Enemies> object) {
        // Implement tick logic for Juaquim enemy
        // ...
    }

    @Override
    public void render(Graphics graphic) {
        // Implement render logic for Juaquim enemy
        // ...
    }

    @Override
    public Rectangle getBounds() {
        // Implement bounding box logic for Juaquim enemy
        // ...
        return null;
    }
    public static int getType() { return type;}

    public static class Juaquim extends EnemyFactory {

        private float width=96, height=128;
        private final float maxSpeed = 15;
        private Handler handler;
        Texture texture= Game.getInstance();
        private Animation JuaquimWalk,JuaquimWalkLeft;

        public Juaquim(float x, float y,Handler handler) {
            super(x, y);
            type = 1;
            this.handler = handler;
            JuaquimWalkLeft = new Animation(5,true,texture.juaquim_vector[0],texture.juaquim_vector[1],texture.juaquim_vector[2],texture.juaquim_vector[3],texture.juaquim_vector[4]);
            JuaquimWalk = new Animation(5,true,texture.juaquim_vector[5],texture.juaquim_vector[6],texture.juaquim_vector[7],texture.juaquim_vector[8],texture.juaquim_vector[9] );

        }

        @Override
        public void tick(LinkedList<Enemies> object) {

        }

        @Override
        public void render(Graphics graphic) {

        }

        @Override
        public Rectangle getBounds() {
            return new Rectangle((int) x, (int) y, 96, 128);
        }

    }

}