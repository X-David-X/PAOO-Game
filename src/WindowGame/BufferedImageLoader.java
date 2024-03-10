package WindowGame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class BufferedImageLoader {
    private BufferedImage image=null;
    public BufferedImage loadImage(String path)
    {
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(path)));
        } catch (IOException e) {
           e.printStackTrace();
        }
        return image;
    }
}
