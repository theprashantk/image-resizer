package image.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by thegod on 16/2/17.
 */
public class ImageCommons {

    public static final Logger LOGGER = Logger.getLogger(ImageCommons.class.getName());

    public static void writeInputStream(InputStream is, OutputStream os){

        try {
            byte[] bytes = new byte[1024];
            int offset = 0 ;

            while (true){
                offset = is.read(bytes);
                if (offset <= 0 ) break;
                os.write(bytes, 0, offset);
            }
        }catch (IOException e){
            LOGGER.log(Level.SEVERE, "Erro while writing image file");
        }
    }

    public static void saveImages(BufferedImage bufferedImage, File file, String type){

        try {

            ImageIO.write(bufferedImage, type, file);
        }catch (Exception e){
            LOGGER.log(Level.SEVERE, "Image Write Failed");
        }
    }

    public static BufferedImage loadImage(File file){

        try {
            return ImageIO.read(file);
        }catch (IOException e){
            LOGGER.log(Level.SEVERE, "Unable to Read Image File");
        }
        return null;
    }

}
