package WindowGame;

import Framework.GameObject;
import Framework.Enemies;

import java.awt.*;
import java.util.LinkedList;

public class EnemyHandler {

    public LinkedList<Enemies> object_enemy = new LinkedList<Enemies>();

    private Enemies tempEnemy;

    public void tick()
    {
        for(int i =0;i<object_enemy.size();i++)
        {
            tempEnemy=object_enemy.get(i);
            tempEnemy.tick(object_enemy);
        }
    }

    public void render(Graphics g)
    {
        for(int i =0;i<object_enemy.size();i++)
        {
            tempEnemy=object_enemy.get(i);
            tempEnemy.render(g);
        }


    }
    public void addEnemy(Enemies objEnemy){
        this.object_enemy.add(objEnemy);
    }
    public void removeEnemy(Enemies objEnemy){
        this.object_enemy.remove(objEnemy);
    }

}
