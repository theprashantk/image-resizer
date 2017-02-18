package image.download;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by thegod on 16/2/17.
 */
public class ImageDownloader {

    public static final Logger LOGGER = Logger.getLogger(ImageDownloader.class.getName());

    public boolean downloadImage(String imageUrl, String loaction){

        try {
            URL url = new URL(imageUrl);
            if(imageUrl.startsWith("https")) {
                downloadHttpsImage(url, loaction);
            } else
                downloadHttpImage(url, loaction);
        }catch (MalformedURLException malformedUrlException){
            LOGGER.log(Level.SEVERE, malformedUrlException.getMessage());
            return false;
        }
        return true;
    }


    public boolean downloadHttpImage(URL url, String location){

        OutputStream imageOutputStream = null;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("USER_AGENT", "Chrome/27.0");
            connection.setInstanceFollowRedirects(true);
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_MOVED_PERM){
                String newLocation = connection.getHeaderField("LOCATION");
                return downloadImage(newLocation, location);
            }
            InputStream imageInputStream = connection.getInputStream();
            imageOutputStream = new FileOutputStream(location);
            byte[] bytes = new byte[1024]; // Create the byte array to hold the
            // data
            int offset = 0; // Read in the bytes

            while (true) {
                offset = imageInputStream.read(bytes);
                if (offset <= 0)
                    break;
                imageOutputStream.write(bytes, 0, offset);
            }
        }catch (IOException ioException){
            LOGGER.log(Level.SEVERE, "Image not downloaded");
            return false;
        }
        return true;
    }


    public boolean downloadHttpsImage(URL url, String location){

        OutputStream imageOutputStream = null;
        try {
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("USER_AGENT", "Chrome/27.0");
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_MOVED_PERM) {
                String newLocation = connection.getHeaderField("LOCATION");
                return downloadImage(newLocation, location);

            }
            InputStream imageInputStream = connection.getInputStream();
            imageOutputStream = new FileOutputStream(location);
            byte[] bytes = new byte[1024]; // Create the byte array to hold the
            // data
            int offset = 0; // Read in the bytes

            while (true) {
                offset = imageInputStream.read(bytes);
                if (offset <= 0)
                    break;
                imageOutputStream.write(bytes, 0, offset);
            }
        }catch (IOException ioException){
            LOGGER.log(Level.SEVERE, "Image not downloaded");
            return false;
        }
        return true;
    }
}
