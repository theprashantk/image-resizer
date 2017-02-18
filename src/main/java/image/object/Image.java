package image.object;

import java.util.Arrays;

/**
 * Created by thegod on 17/2/17.
 */
public class Image {


    private String name;
    private String downlaodUrl;
    private String location;
    private String type;
    private boolean isDownloaded;
    private int[][] size;

    public int[] getSize(int heightIndex) {
        return size[heightIndex];
    }

    public void setSize(int[][] size) {
        this.size = size;
    }

    public Image(){}

    public Image(String downlaodUrl, String name, String location){

        this.downlaodUrl = downlaodUrl;
        this.name = name;
        this.location = location;
    }



    public boolean isDownloaded() {
        return isDownloaded;
    }

    public void setDownloaded(boolean downloaded) {
        isDownloaded = downloaded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDownlaodUrl() {
        return downlaodUrl;
    }

    public void setDownlaodUrl(String downlaodUrl) {
        this.downlaodUrl = downlaodUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Image{");
        sb.append("name='").append(name).append('\'');
        sb.append(", downlaodUrl='").append(downlaodUrl).append('\'');
        sb.append(", location='").append(location).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append(", isDownloaded=").append(isDownloaded);
        sb.append(", size=").append(size == null ? "null" : Arrays.asList(size).toString());
        sb.append('}');
        return sb.toString();
    }
}
