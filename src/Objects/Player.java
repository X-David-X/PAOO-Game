package Objects;
import Database.DatabaseClass;
import Framework.GameObject;
import Framework.ObjectID;
import Framework.Texture;
import WindowGame.Animation;
import WindowGame.Camera;
import WindowGame.Game;
import WindowGame.Handler;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;

public class Player extends GameObject {
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private float width=96, height=128;
    private final float maxSpeed = 20;
    private float gravity = 2.5f;
    public static int shooting = 0, m4a1 =0;
    private  Handler handler;
    private Camera cam;
    Texture texture= Game.getInstance();
    private Animation playerWalk,playerWalkLeft;
    public static int score=0;
    public static int damage_bullet = 1;
    public static int hp = 3;
    public static DatabaseClass database_score = new DatabaseClass();
    /////////////////////////////////////////////////////
    ///////////////////SINGLETON////////////////////////
    ///////////////////////////////////////////////////
    private static Player instance;


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Player(float x, float y,int hp,Handler handler, ObjectID ID,Camera cam)
    {
        super(x, y, ID);
        this.handler=handler;
        this.cam = cam;
        this.hp=hp;

        /////////////////////////////////////////////////////////
        // Those 2 if statemens are used to load the player at the bottom of the map, then check if the position is right, if return is true, move it to the "spawn" location;
        //              -> so the background tiles will not appear in front of the Player;
        if(Game.Level ==0 ) setSpawn(32,55);
        if(Game.Level == 1) setSpawn(15,14);
        if(Game.Level == 2) setSpawn(5,26);
        /////////////////////////////////////////////////////////////////

        playerWalk = new Animation(5,false,texture.player[0],texture.player[1],texture.player[2] );
        playerWalkLeft = new Animation(5,false,texture.player[3],texture.player[4],texture.player[5] );
        //database_score.create_table();
        //score = database_score.getScore();
        //instance = this;

    }

    public static Player GetInstance(float x, float y,int hp,Handler handler, ObjectID ID,Camera cam) {

        if (instance == null) {
            instance = new Player(x, y, hp, handler, ID, cam);
        }
        return instance;
    }

    /*public Player(float x, float y,int hp,Handler handler, ObjectID ID,Camera cam)
    {
        super(x, y, ID);
        this.handler=handler;
        this.cam = cam;
        this.hp=hp;

        /////////////////////////////////////////////////////////
        // Those 2 if statemens are used to load the player at the bottom of the map, then check if the position is right, if return is true, move it to the "spawn" location;
        //              -> so the background tiles will not appear in front of the Player;
        if(x==119*64 && y==64*64 && Game.Level ==0 ) setSpawn(32,55);
        if(Game.Level == 1) setSpawn(15,14);
        if(Game.Level == 2) setSpawn(5,26);
        /////////////////////////////////////////////////////////////////

        playerWalk = new Animation(5,false,texture.player[0],texture.player[1],texture.player[2] );
        playerWalkLeft = new Animation(5,false,texture.player[3],texture.player[4],texture.player[5] );
        //database_score.create_table();
        //score = database_score.getScore();
        //instance = this;




        public static Player GetInstance(float x, float y,int hp,Handler handler, ObjectID ID,Camera cam) {

        if (instance == null) {
            instance = new Player(x, y, hp, handler, ID, cam);
        }
        return instance;
    }*/

    public static void ResetInstance() {
        instance = null;
    }


    public void tick(LinkedList<GameObject> object) {

        if (hp <= 0) {
            Game.State = Game.STATE.GameOver;
            hp=3;
        }
        if(score > 20000)
        {
            damage_bullet = 5;
        }
        x += velX;
        y += velY;

        //Handler.databaseLoad.savePlayerPosition(hp,x ,y);

        if(velX < 0)
            facing = -1;
        else if(velX > 0)
            facing = 1;

        if(falling || jumping)
        {
            velY += gravity;
            if(velY > maxSpeed)          //handler pentru cat de rapid sa cada
                velY = maxSpeed;
        }

        Collision(object);
        playerWalk.runAniamtion();
        playerWalkLeft.runAniamtion();
    }


    private void Collision(LinkedList<GameObject>object) {
       // boolean intersected = false;
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getID() == ObjectID.Block) {
                if (getBoundsTop().intersects(tempObject.getBounds())) {

                    y = tempObject.getY() + height / 2;
                    velY = 0;
                }
                if (getBounds().intersects(tempObject.getBounds())) {
                    y = tempObject.getY() - height + 1;
                    velY = 0;
                    jumping = false;
                    falling = false;
                } else
                {
                    falling = true;
                }

                if (getBoundsRight().intersects(tempObject.getBounds())) {

                    x = tempObject.getX() - width;
                }

                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    x = tempObject.getX() + 64;
                }

            }
            if (tempObject.getID() == ObjectID.Flag) {

                if(tempObject.getType() == 1) {
                  if (getBoundsRight().intersects(tempObject.getBounds())) {
                        handler.switchLevel(1);

                    }
                }
                if(tempObject.getType() == 2)
                {
                    if (getBoundsRight().intersects(tempObject.getBounds())) {
                        handler.switchLevel(2);
                    }
                }
            }

            if(Game.Level == 1)
            {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if( tempObject.getType()==17)
                    {
                    velX=0;
                    velY=0;
                    setSpawn(15,14);
                    this.decreaseHP();
                    }
                }

            }


            if (tempObject.getID() == ObjectID.Pickable) {


                // coliziuni pt glock
                if (getBounds().intersects(tempObject.getBounds()) && tempObject.getType() == 1) {
                    shooting = 1;
                    handler.removeObject(tempObject);
                }
                if (getBoundsLeft().intersects(tempObject.getBounds()) && tempObject.getType() == 1) {
                    shooting = 1;
                    handler.removeObject(tempObject);

                }
                if (getBoundsTop().intersects(tempObject.getBounds()) && tempObject.getType() == 1) {
                    shooting = 1;
                    handler.removeObject(tempObject);
                }
                if (getBoundsRight().intersects(tempObject.getBounds()) && tempObject.getType() == 1) {
                    shooting = 1;
                    handler.removeObject(tempObject);
                }

                //coliziuni pt gogoasa
                if (getBounds().intersects(tempObject.getBounds()) && tempObject.getType() == 2) {
                    score+=10;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);
                }
                if (getBoundsLeft().intersects(tempObject.getBounds()) && tempObject.getType() == 2) {
                   score+=10;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);

                }
                if (getBoundsTop().intersects(tempObject.getBounds()) && tempObject.getType() == 2) {
                    score+=10;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);
                }
                if (getBoundsRight().intersects(tempObject.getBounds()) && tempObject.getType() == 2) {
                    score+=10;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);
                }

                //Coliziuni pt Hamburger
                if (getBounds().intersects(tempObject.getBounds()) && tempObject.getType() == 0) {
                    score+=500;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);
                }
                if (getBoundsLeft().intersects(tempObject.getBounds()) && tempObject.getType() == 0) {
                    score+=500;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);

                }
                if (getBoundsTop().intersects(tempObject.getBounds()) && tempObject.getType() == 0) {
                    score+=500;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);
                }
                if (getBoundsRight().intersects(tempObject.getBounds()) && tempObject.getType() == 0) {
                    score+=500;
                    handler.removeObject(tempObject);
                    database_score.setScore(score);
                }

                //Coliziune m4a1
                if (getBounds().intersects(tempObject.getBounds()) && tempObject.getType() == 3) {
                    m4a1 = 1;
                    handler.removeObject(tempObject);
                }
                if (getBoundsLeft().intersects(tempObject.getBounds()) && tempObject.getType() == 3) {
                    m4a1 = 1;
                    handler.removeObject(tempObject);

                }
                if (getBoundsTop().intersects(tempObject.getBounds()) && tempObject.getType() == 3) {
                    m4a1 = 1;
                    handler.removeObject(tempObject);
                }
                if (getBoundsRight().intersects(tempObject.getBounds()) && tempObject.getType() == 3) {
                    m4a1 = 1;
                    handler.removeObject(tempObject);
                }

            }
            if (tempObject.getID() == ObjectID.EnemyJuaquim) {
                if (getBoundsTop().intersects(tempObject.getBounds())) {
                    if(Game.Level == 1) setSpawn(15, 14);
                    else if(Game.Level == 2) setSpawn(5,26);
                    else setSpawn(32, 55);
                    this.decreaseHP();
                }
                if (getBounds().intersects(tempObject.getBounds())) {

                    if(Game.Level == 1) setSpawn(15, 14);
                    else if(Game.Level == 2) setSpawn(5,26);
                    else setSpawn(32, 55);
                    this.decreaseHP();
                }

                if (getBoundsRight().intersects(tempObject.getBounds())) {
                    if(Game.Level == 1) setSpawn(15, 14);
                    else if(Game.Level == 2) setSpawn(5,26);
                    else setSpawn(32, 55);
                    this.decreaseHP();
                }

                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    if(Game.Level == 1) setSpawn(15, 14);
                    else if(Game.Level == 2) setSpawn(5,26);
                    else setSpawn(32, 55);
                    this.decreaseHP();
                }
            }
            if(tempObject.getID() == ObjectID.Eric_Boss)
            {
                if (getBounds().intersects(tempObject.getBounds())) {
                    this.hp=0;
                    setSpawn(5, 26);
                    this.decreaseHP();
                }
                if (getBoundsLeft().intersects(tempObject.getBounds())) {
                    this.hp=0;
                    setSpawn(5, 26);
                    this.decreaseHP();
                }
                if (getBoundsTop().intersects(tempObject.getBounds())) {

                    this.hp=0;
                    setSpawn(5, 26);
                    this.decreaseHP();
                }
                if (getBoundsRight().intersects(tempObject.getBounds()) ) {
                    this.hp=0;
                    setSpawn(5, 26);
                    this.decreaseHP();
                }
            }


        }
    }

    @Override
    public void render(Graphics graphic) {


        // The image loader for the texture of the player
        //graphic.setColor(Color.CYAN);

        if(jumping)
        {
            if(facing == 1)
            {
                graphic.drawImage(texture.player_jump[0],(int)x,(int)y,null);
            }
            else if(facing == -1)
            {
                graphic.drawImage(texture.player_jump[1],(int)x,(int)y,null);
            }
        }
        else
        {
            if(velX != 0)
            {
                if(facing == 1 )
                    playerWalk.drawAnimation(graphic,(int)x,(int)y);
                else playerWalkLeft.drawAnimation(graphic,(int)x,(int)y);
            }
            else {
                if(facing == 1)
                {
                    graphic.drawImage(texture.player[0],(int)x,(int)y,null);
                }
                else if (facing == -1)
                {
                    graphic.drawImage(texture.player[3],(int)x,(int)y,null);
                }

            }

        }


        /*
        graphic.setColor(Color.blue);
        graphic.fillRect((int)x,(int)y,96,128);
        Graphics2D g2d =(Graphics2D) graphic;
        g2d.setColor(Color.YELLOW);
        g2d.draw(getBounds());
        g2d.draw(getBoundsLeft());
        g2d.draw(getBoundsRight());
        g2d.draw(getBoundsTop());
*/
    }

    public Rectangle getBounds() {
        return new Rectangle((int) (x + width / 4), (int) (y + height / 2), (int)(width / 2), (int)(height / 2));
    }

    public Rectangle getBoundsTop() {
        return new Rectangle((int) (x + width/4 ), (int) y, (int)(width / 2), (int)(height / 4));
    }

    public Rectangle getBoundsRight() {
        return new Rectangle((int) (x + width -width/8), (int) (y + height / 8 - 12), (int)(width /8), (int)(height - height / 8 + 8));
    }

    public Rectangle getBoundsLeft() {
        return new Rectangle((int) x, (int) (y + height / 8 - 12), (int)(width / 8), (int)(height - height / 6 +16));
    }


    public void decreaseHP() {
        hp -= 1;
    }
    public void setSpawn(int x, int y)
    {
        this.x = x*64;
        this.y = y*64;
    }

    public int getScore()
    {
        return score;
    }
    public void increaseScore(int amount)
    {
        score += amount;
    }
    public int getPlayerHp()
    {
        return hp;
    }
    public void setGravity(float grav)
    {
        this.gravity = grav;
    }
    public void decreaseHpAmount(int amount)
    {
        hp -= amount;
    }




























    /*private int rectangleX;
    private int rectangleY;
    private static final int RECTANGLE_WIDTH = 96;
    private static final int RECTANGLE_HEIGHT = 128;
    private static final int TILE_SIZE = 64;

    private void resolveCollision(float tileX, float tileY) {
        // Calculate the overlap on each axis
        int overlapX = Math.min ((int)(rectangleX + RECTANGLE_WIDTH - tileX), (int)(tileX + TILE_SIZE - rectangleX));
        int overlapY = Math.min((int)(rectangleY + RECTANGLE_HEIGHT - tileY), (int) (tileY + TILE_SIZE - rectangleY));

        // Determine the axis with the smallest overlap
        if (overlapX < overlapY) {
            // Adjust the position along the X-axis
            if (rectangleX + RECTANGLE_WIDTH / 2 < (int)(tileX + TILE_SIZE / 2)) {
                rectangleX -= overlapX;
            } else {
                rectangleX += overlapX;
            }
        } else {
            // Adjust the position along the Y-axis
            if ((rectangleY + (RECTANGLE_HEIGHT) / 2) < ((int)tileY + TILE_SIZE / 2)) {
                rectangleY -= overlapY;
            } else {
                rectangleY += overlapY;
            }
        }
    }*/


}

