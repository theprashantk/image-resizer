package image;

import image.download.ImageDownloader;
import image.object.Image;
import image.utils.ImageCommons;
import image.utils.ImageScalar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by thegod on 17/2/17.
 */
public class ImageResizer {

    private static final Logger LOGGER = Logger.getLogger(ImageResizer.class.getName());

    public void start(int [][] size, String... args){

        Image image = null;

        if (args.length == 1){
            image = new Image(args[0], "default_image", System.getProperty("user.dir").endsWith("/") ?  System.getProperty("user.dir"): System.getProperty("user.dir") + "/");
        } else if (args.length == 2){
            image = new Image(args[0], "default_image", args[1].endsWith("/") ? args[1] : args[1] + "/");
        } else if (args.length == 3){
            image = new Image(args[0], args[2], args[1].endsWith("/") ? args[1] : args[1] + "/");
        } else if (args.length == 4){
            image = new Image(args[0], args[2], args[1].endsWith("/") ? args[1] : args[1] + "/");
            image.setType(args[3]);
        }
        image.setType(image.getType() == null ? "jpg" : image.getType());

        LOGGER.info(  image.toString());
        ImageDownloader imageDownloader = new ImageDownloader();
        image.setDownloaded(imageDownloader.downloadImage(image.getDownlaodUrl(), image.getLocation() + image.getName()));
        LOGGER.log(Level.INFO, "Image Downloaded: {} ", image.isDownloaded());

        if ( !image.isDownloaded()) System.exit(1);
        image.setSize(size);

        for (int heightIndex = 0; heightIndex < size.length; heightIndex++){
            BufferedImage bufferedImage = ImageScalar.resize(ImageCommons.loadImage(new File(image.getLocation()+image.getName())), ImageScalar.Method.QUALITY, ImageScalar.Mode.FIT_EXACT, image.getSize(heightIndex)[0], image.getSize(heightIndex)[1] );
            ImageCommons.saveImages(bufferedImage, new File(image.getLocation() + image.getName()+ "_" + image.getSize(heightIndex)[0] + "X" + image.getSize(heightIndex)), image.getType());
        }
    }



    public static void main(String args[]){

    }
}
