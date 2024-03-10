package Framework;

import Objects.*;
import WindowGame.Game;
import WindowGame.Handler;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class KeyInput extends KeyAdapter {
    Handler handler;
    long startTime = System.currentTimeMillis();
    int counter = 0;
    int shoot_enable = 0;
    // 0 -> not shooting
    // 1 -> shooting
    protected int bullet_count=40;


    public KeyInput(Handler handler)
    {
        this.handler=handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(key == KeyEvent.VK_O) Game.State = Game.STATE.WinGame;
            if (tempObject.getID() == ObjectID.Player) {
                if(key == KeyEvent.VK_M) tempObject.setSpawn(23,24);
                if(key == KeyEvent.VK_P) tempObject.increaseScore(20000);
                if (key == KeyEvent.VK_ESCAPE)
                {
                    if(Game.State == Game.STATE.GAME)
                        Game.State = Game.STATE.PAUSED;
                    else if(Game.State == Game.STATE.PAUSED)
                        Game.State = Game.STATE.GAME;
                }
                if(Game.State == Game.STATE.GAME) {

                    if (key == KeyEvent.VK_R)
                    {
                            if(Game.Level ==1 ) {
                            tempObject.setSpawn(15, 14);
                                //Handler.databaseLoad.savePlayerPosition(tempObject.getPlayerHp(),tempObject.getX(),tempObject.getY());
                            }
                            else if(Game.Level == 0) {
                                tempObject.setSpawn(34, 55);
                               // Handler.databaseLoad.savePlayerPosition(tempObject.getPlayerHp(), tempObject.getX(), tempObject.getY());
                            }
                            else if(Game.Level == 2)
                            {
                                tempObject.setSpawn(5,26);
                                //Handler.databaseLoad.savePlayerPosition(tempObject.getPlayerHp(), tempObject.getX(), tempObject.getY());
                            }

                    }
                    if( key == KeyEvent.VK_SHIFT)
                    {
                        if(Game.Level == 1)
                        {
                            if(tempObject.isJumping()) {
                                tempObject.setVelX(tempObject.getVelX() + tempObject.facing*5);
                                tempObject.jumping =false;
                                tempObject.setVelY(-2);
                            }
                        }
                    }
                    if (key == KeyEvent.VK_N) {
                        if(Game.Level == 0)
                           tempObject.setSpawn(105, 39);
                        if(Game.Level == 1)
                            tempObject.setSpawn(107,55);


                    }
                    if (key == KeyEvent.VK_H) Player.shooting = 1;
                    if (key == KeyEvent.VK_D) tempObject.setVelX(15);
                    if (key == KeyEvent.VK_A) tempObject.setVelX(-15);
                    if (key == KeyEvent.VK_W && !tempObject.isJumping()) {
                        //x8 jump value = x64 pixels
                        tempObject.setJumping(true);
                        tempObject.setVelY(-40);

                    }
                    if (key == KeyEvent.VK_SPACE && Player.shooting == 1) {
                        if (tempObject.getFacing() == 1) {

                            if (bullet_count != 0) {
                                long currentTime = System.currentTimeMillis();
                                if (currentTime - startTime >= 500) {
                                    counter++;
                                    startTime = currentTime;

                                    handler.addObject(new Bullet(tempObject.getX() + 96, tempObject.getY() + 64, ObjectID.Bullet, tempObject.getFacing() * 40, handler,2));

                                }
                                bullet_count--;
                            } else {
                                System.out.println("Out of ammo");
                                bullet_count += 40;

                            }

                        } else if (tempObject.getFacing() == -1) {
                            if (bullet_count != 0) {
                                long currentTime = System.currentTimeMillis();
                                if (currentTime - startTime >= 500) {
                                    counter++;
                                    startTime = currentTime;

                                    handler.addObject(new Bullet(tempObject.getX(), tempObject.getY() + 64, ObjectID.Bullet, tempObject.getFacing() * 40, handler,1));

                                }
                                bullet_count--;
                            } else {
                                System.out.println("Out of ammo");
                                bullet_count += 40;

                            }
                        }

                    }
                    if (key == KeyEvent.VK_CONTROL && Player.m4a1 == 1) {
                        if (tempObject.getFacing() == 1) {

                            if (bullet_count != 0) {
                                long currentTime = System.currentTimeMillis();
                                if (currentTime - startTime >= 500) {
                                    counter++;
                                    startTime = currentTime;

                                    handler.addObject(new BigBullet(tempObject.getX() + 96, tempObject.getY() + 64, ObjectID.BigBullet, tempObject.getFacing() * 40, handler,2));

                                }
                                bullet_count--;
                            } else {
                                System.out.println("Out of ammo");
                                bullet_count = 40;

                            }

                        } else if (tempObject.getFacing() == -1) {
                            if (bullet_count != 0) {
                                long currentTime = System.currentTimeMillis();
                                if (currentTime - startTime >= 500) {
                                    counter++;
                                    startTime = currentTime;
                                    handler.addObject(new BigBullet(tempObject.getX() + 96, tempObject.getY() + 64, ObjectID.BigBullet, tempObject.getFacing() * 40, handler,1));

                                }
                                bullet_count--;
                            } else {
                                System.out.println("Out of ammo");
                                bullet_count += 40;

                            }
                        }

                    }
                }
            }
        }
    }

    public void keyReleased(KeyEvent e){

        int key=e.getKeyCode();

        for(int i=0;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID()==ObjectID.Player)             // verific ce lui e player/inamic
            {
                if(key == KeyEvent.VK_D) tempObject.setVelX(0);                  // merg dreapta
                if(key == KeyEvent.VK_A) tempObject.setVelX(0);                 //  merg stanga


            }
        }
    }


}
