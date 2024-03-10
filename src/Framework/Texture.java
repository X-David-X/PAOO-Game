package Framework;

import WindowGame.BufferedImageLoader;

import java.awt.image.BufferedImage;

public class Texture {
    SpriteSheet bs,ps,bullet_s,big_bullet_s,bs_doi,pickable,Hp,enemy_juaquim,block_t,gogoasa,cn,cn_b,mitrl,boss;  //player shhet, block sheet
    private BufferedImage block_sheet=null;
    private BufferedImage player_sheet=null;
    private BufferedImage bullet_sheet= null;
    private BufferedImage background_images_stalp=null;
    private BufferedImage block_sheet_doi=null;
    private BufferedImage pickable_sheet = null;
    private BufferedImage hp_sheet=null;
    private BufferedImage juaquim_sheet =null;
    private BufferedImage block_transport = null;
    private BufferedImage gogo =null;
    private BufferedImage canon_ball = null;
    private BufferedImage canon = null;
    private BufferedImage m4a1s = null;
    private BufferedImage eric = null;
    private BufferedImage big_b =null;

    public BufferedImage[] block = new BufferedImage[25];
    public BufferedImage[] block_doi = new BufferedImage[25];
    public BufferedImage[] player = new BufferedImage[8];
    public BufferedImage[] player_jump = new BufferedImage[2];
    public BufferedImage[] bullet = new BufferedImage[2];
    public BufferedImage[] pickable_obj = new BufferedImage[3];
    public BufferedImage[] hp_vector = new BufferedImage[3];
    public BufferedImage[] juaquim_vector = new BufferedImage[10];
    public BufferedImage[] block_transport_vect = new BufferedImage[2];
    public BufferedImage[] gogoasa_vec = new BufferedImage[1];
    public BufferedImage[] canon_bal_vec = new BufferedImage[1];
    public BufferedImage[] canon_vec = new BufferedImage[10];
    public BufferedImage[] mitraliera = new BufferedImage[1];
    public BufferedImage[] eric_sheet = new BufferedImage[2];
    public BufferedImage[] big_bullet_vec = new BufferedImage[2];
    public Texture(){
        BufferedImageLoader loader = new BufferedImageLoader();
        try{
            block_sheet = loader.loadImage("Resource/Blocks_spritesheet.png");
            player_sheet = loader.loadImage("Resource/Jamal-sprite-photoshop 96x128.png");
            bullet_sheet = loader.loadImage("Resource/bullet-sheet.png");
            block_sheet_doi = loader.loadImage("Resource/Blocks_spritesheet.png");
            background_images_stalp = loader.loadImage("Resource/Blocks Sprite.png");
            pickable_sheet = loader.loadImage("Resource/pickable.png");
            hp_sheet = loader.loadImage("Resource/heath_bar_sheet.png");
            juaquim_sheet = loader.loadImage("Resource/Full-inamic-sheet.png");
            block_transport = loader.loadImage("Resource/block-transport.png");
            gogo = loader.loadImage("Resource/gogoasa.png");
            canon = loader.loadImage("Resource/Tun-sheet.png");
            canon_ball = loader.loadImage("Resource/Canon-ball.png");
            m4a1s = loader.loadImage("Resource/mpa1s-arma.png");
            eric = loader.loadImage("Resource/Eric-boss-sheet.png");
            big_b = loader.loadImage("Resource/Glont-mare.png");

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        bs =new SpriteSheet(block_sheet);
        bs_doi = new SpriteSheet(block_sheet_doi);
        ps=new SpriteSheet(player_sheet);
        bullet_s=new SpriteSheet(bullet_sheet);
        pickable = new SpriteSheet(pickable_sheet);
        Hp = new SpriteSheet(hp_sheet);
        enemy_juaquim = new SpriteSheet(juaquim_sheet);
        block_t = new SpriteSheet(block_transport);
        gogoasa = new SpriteSheet(gogo);
        cn_b = new SpriteSheet(canon_ball);
        cn = new SpriteSheet(canon);
        mitrl = new SpriteSheet(m4a1s);
        boss = new SpriteSheet(eric);
        big_bullet_s = new SpriteSheet(big_b);


        getTextuers();
    }

    private void getTextuers()
    {
        block[0]=bs.grabImage(1,1,64,64);
        block[1]=bs.grabImage(2,1,64,64);
        block[2]=bs.grabImage(3,1,64,64);
        block[3]=bs.grabImage(4,1,64,64);
        block[4]=bs.grabImage(5,1,64,64);
        block[5]=bs.grabImage(6,1,64,64);
        block[6]=bs.grabImage(7,1,64,64);
        block[7]=bs.grabImage(8,1,64,64);
        block[8]=bs.grabImage(9,1,64,64);
        block[9]=bs.grabImage(10,1,64,64);
        block[10]=bs.grabImage(11,1,64,64);
        block[11]=bs.grabImage(12,1,64,64);
        block[12]=bs.grabImage(13,1,64,64);
        block[13]=bs.grabImage(14,1,64,64);
        block[14]=bs.grabImage(15,1,64,64);
        block[15]=bs.grabImage(16,1,64,64);
        block[16]=bs.grabImage(17,1,64,64);
        block[17]=bs.grabImage(18,1,64,64);



        block_doi[0]=bs_doi.grabImage(1,1,64,64);
        block_doi[1]=bs_doi.grabImage(2,1,64,64);
        block_doi[2]=bs_doi.grabImage(3,1,64,64);
        block_doi[3]=bs_doi.grabImage(4,1,64,64);
        block_doi[4]=bs_doi.grabImage(5,1,64,64);
        block_doi[5]=bs_doi.grabImage(6,1,64,64);
        block_doi[6]=bs_doi.grabImage(7,1,64,64);
        block_doi[7]=bs_doi.grabImage(8,1,64,64);
        block_doi[8]=bs_doi.grabImage(9,1,64,64);
        block_doi[9]=bs_doi.grabImage(10,1,64,64);
        block_doi[10]=bs_doi.grabImage(11,1,64,64);
        block_doi[11]=bs_doi.grabImage(12,1,64,64);
        block_doi[12]=bs_doi.grabImage(13,1,64,64);
        block_doi[13]=bs_doi.grabImage(14,1,64,64);
        block_doi[14]=bs_doi.grabImage(15,1,64,64);
        block_doi[15]=bs_doi.grabImage(16,1,64,64);
        block_doi[16]=bs_doi.grabImage(17,1,64,64);



        player[0]=ps.grabImage(1,1,96,128); // afk jamal drt
        player[1]=ps.grabImage(2,1,96,128);//jamal drt pas1
        player[2]=ps.grabImage(3,1,96,128);//jamal drt pas2
        player[3]=ps.grabImage(4,1,96,128);//jamal afk stg
        player[4]=ps.grabImage(5,1,96,128);//jamal afk stg pas1
        player[5]=ps.grabImage(6,1,96,128);//jamal afk stg pas2
        player[6]=ps.grabImage(7,1,96,128);//jamal pistol drt
        player[7]=ps.grabImage(8,1,96,128);//jamal pistol stg

        juaquim_vector[0]=enemy_juaquim.grabImage(1,1,96,128);//stanga stat
        juaquim_vector[1]=enemy_juaquim.grabImage(2,1,96,128);//stanga pas mic
        juaquim_vector[2]=enemy_juaquim.grabImage(3,1,96,128);//stanga pas mare
        juaquim_vector[3]=enemy_juaquim.grabImage(4,1,96,128);//stanga pas mic 2
        juaquim_vector[4]=enemy_juaquim.grabImage(5,1,96,128);//stanga pas mare 2
        juaquim_vector[5]=enemy_juaquim.grabImage(6,1,96,128);//drt pas mare 2
        juaquim_vector[6]=enemy_juaquim.grabImage(7,1,96,128);//drt pas mic 2
        juaquim_vector[7]=enemy_juaquim.grabImage(8,1,96,128);//drt pas mare
        juaquim_vector[8]=enemy_juaquim.grabImage(9,1,96,128);//drt pas mic
        juaquim_vector[9]=enemy_juaquim.grabImage(10,1,96,128);//drt stat

        canon_vec[0]= cn.grabImage(1,1,128,64);
        canon_vec[1]= cn.grabImage(2,1,128,64);
        canon_vec[2]= cn.grabImage(3,1,128,64);
        canon_vec[3]= cn.grabImage(4,1,128,64);
        canon_vec[4]= cn.grabImage(5,1,128,64);
        canon_vec[5]= cn.grabImage(6,1,128,64);
        canon_vec[6]= cn.grabImage(7,1,128,64);
        canon_vec[7]= cn.grabImage(8,1,128,64);

        eric_sheet[0]=boss.grabImage(1,1,1024,768);
        eric_sheet[1]=boss.grabImage(2,1,1024,768);

        canon_bal_vec[0] = cn_b.grabImage(1,1,32,32);


        player_jump[0]=ps.grabImage(3,1,96,128); // jamal jump drt
        player_jump[1]=ps.grabImage(6,1,96,128); // jamal jump

        bullet[0]=bullet_s.grabImage(1,1,16,16);
        bullet[1]=bullet_s.grabImage(2,1,16,16);

        big_bullet_vec[0]= big_bullet_s.grabImage(1,1,32,16);
        big_bullet_vec[1]= big_bullet_s.grabImage(2,1,32,16);

        pickable_obj[0]= pickable.grabImage(1,1,64,64);     // burgir
        pickable_obj[1]= pickable.grabImage(2,1,64,64);     // pistol

        hp_vector[0] = Hp.grabImage(1,1,64,64);
        hp_vector[1] = Hp.grabImage(2,1,64,64);
        hp_vector[2] = Hp.grabImage(3,1,64,64);

        block_transport_vect[0] = block_t.grabImage(1,1,64,64);
        block_transport_vect[1] = bs.grabImage(11,1,64,64);


        gogoasa_vec[0] = gogoasa.grabImage(1,1,64,64);
        mitraliera[0] = mitrl.grabImage(1,1,128,64);




    }

}
