package Objects;

import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.lang.reflect.GenericArrayType;
import java.util.LinkedList;

public class EricBoss extends GameObject {
    Handler handler;
    public int type = 2;
    Texture texture = Game.getInstance();
    public static int stagiu = 1,hp=100;

    private long lastSummonTime;
    private boolean canSummonCanonball;

    public EricBoss(float x, float y, ObjectID ID,Handler handler){
        super(x, y, ID);
        this.handler=handler;

    }

    @Override
    public void tick(LinkedList<GameObject> object) {
        if(hp <= 50)
        {
            type = 2;
        }
        if(hp <=0)
        {
            Game.State = Game.STATE.WinGame;
        }
        long currentTime = System.currentTimeMillis();
        long timeSinceLastSummon = currentTime - lastSummonTime;
        if (timeSinceLastSummon >= 12000) {
            canSummonCanonball = true; // Enable canonball summoning
        }
    }

    @Override
    public void render(Graphics graphic) {
        if(type == 1)
        {
            graphic.drawImage(texture.eric_sheet[0],(int)x,(int)y,null );
        }
        if(type == 2)
        {
            graphic.drawImage(texture.eric_sheet[1],(int)x,(int)y,null );
        }

        if (canSummonCanonball) {
            // Summon the canonball at the desired position
            handler.addObject(new EnemyJuaquim((int) 26 * 64, (int) 26 * 64, ObjectID.Canon_Ball, handler,6));
            handler.addObject(new EnemyJuaquim((int) 36 * 64, (int) 22 * 64, ObjectID.Canon_Ball, handler,6));

            handler.addObject(new CanonBall((int) 55 * 64, (int) 12 * 64, ObjectID.Canon_Ball, -6, handler));
            handler.addObject(new CanonBall((int) 55 * 64, (int) 22 * 64, ObjectID.Canon_Ball, -6, handler));
            handler.addObject(new CanonBall((int) 55 * 64, (int) 27 * 64, ObjectID.Canon_Ball, -6, handler));

            canSummonCanonball = false; // Disable canonball summoning until enough time passes again
            lastSummonTime = System.currentTimeMillis(); // Update the last summon time
        }

    }

    @Override
    public Rectangle getBounds() {

        return new Rectangle((int)x+180,(int)y,800,800);
    }

    public void decreaseHpBoss(int amount)
    {
        hp -= amount;
    }
}
