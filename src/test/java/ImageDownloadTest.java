import image.ImageResizer;
import image.download.ImageDownloader;
import image.utils.ImageCommons;
import image.utils.ImageScalar;
import org.junit.Ignore;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

/**
 * Created by thegod on 16/2/17.
 */
public class ImageDownloadTest {

    public String inputString = "http://media.coast-stores.com/pws/client/images/catalogue/products/8080/zoom/8080.jpg";
    public String in = "<head><title>Document Moved</title></head><body><h1>Object Moved</h1>This document may be found <a HREF=\"https://www.moss.co.uk/images/original/965631324_01.jpg\">here</a></body>";
    @Ignore
    @Test
    public void imageDownloadTest(){
        ImageDownloader imageDownloader = new ImageDownloader();
        imageDownloader.downloadImage(inputString, "/tmp/cdn/imageresize");
    }
    public void testResponseType() throws Exception{

        URL url = new URL(inputString);
        System.out.println(url.openConnection());

    }
      @Ignore
    @Test
    public void  in(){

        System.out.println(in.substring(in.indexOf("<a HREF=") + 9, in.indexOf("<", in.indexOf("<a HREF="))+9));
    }

     @Ignore
    @Test
    public void testResize() throws Exception{
        BufferedImage inputBufferedImage = ImageIO.read(new File("/home/saran/test.png"));
        int height = inputBufferedImage.getHeight();
        int widht = inputBufferedImage.getWidth();
        System.out.println(inputBufferedImage.getType());
        BufferedImage bufferedImage = ImageScalar.resize(inputBufferedImage, ImageScalar.Method.QUALITY, ImageScalar.Mode.FIT_EXACT,50, 50);
        ImageCommons.saveImages(bufferedImage, new File("/tmp/cdn/test80.jpg"), "jpg");

    }

@Ignore
    @Test
    public void checkResizedImage(){

        ImageResizer imageResizer = new ImageResizer();
        int size[][] = {{130, 130}};
        imageResizer.start(size, "http://image1.superdry.com/static/images/products/zoom/upload1107048034743444408.jpg");
    }

    @Test
    public void testString() throws  Exception{


        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/home/saran/Desktop/desc.txt")));
        String st="";
        while((st = bufferedReader.readLine()) != null){
//            String
        }
    }


}
