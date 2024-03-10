package WindowGame;

import Framework.ObjectID;
import Objects.CanonBall;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {
    private int speed;
    private int frames;
    private int index=0;
    private int count=0;
    private BufferedImage[] images;
    private BufferedImage currentImg;
    private boolean shouldSummonBall = false;
    public Handler handler;

    public Animation(int speed,boolean shouldSummonBall,BufferedImage... args){
        this.speed=speed;
        images = new BufferedImage[args.length];
        for(int i=0;i < args.length ; i++)
        {
            images[i] = args[i];
        }
        frames = args.length;
    }

    public void runAniamtion()
    {
        index++;
        if(index > speed)
        {
            index=0;
            nextFrame();

        }
    }

    private void nextFrame()
    {
        //repeat walk animation
        for(int i=0; i<frames;i++)
        {
            if(count == i )
            {
                currentImg = images[i];
            }
        }
        count++;
        if(count > frames)
        {
            count=0;

        }
    }
    public void setShouldSummonBall(boolean shouldSummonBall) {
        this.shouldSummonBall = shouldSummonBall;
    }

    public void drawAnimation(Graphics g,int x, int y)
    {
        g.drawImage(currentImg,x,y,null);
    }
    public void drawAnimation(Graphics g,int x, int y,int scalex,int scaley)
    {
        g.drawImage(currentImg,x,y,scalex,scaley,null);
    }













}
