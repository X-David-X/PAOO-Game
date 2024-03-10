package Framework;

import java.awt.*;
import java.util.LinkedList;

public abstract class Enemies {
    protected float x,y;
    protected float velX=0, velY=0;
    protected int facing = 1;
    // facing = 1 -> right,
    // facing = -1 -> lef
    public Enemies(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick(LinkedList<Enemies> object);

    public abstract void render(Graphics graphic);

    public abstract Rectangle getBounds();

}
