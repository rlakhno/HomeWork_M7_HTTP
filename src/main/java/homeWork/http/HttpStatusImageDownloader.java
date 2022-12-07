package homeWork.http;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HttpStatusImageDownloader {

    void downloadStatusImage(int code) throws Exception {


        BufferedImage image = null;
        String extension = ".jpg";
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String catUrl = httpStatusChecker.getStatusImage(code);
        
        if (catUrl.contains("invalidStatus")) {
            System.out.println("!!! --> WARNING: THE STATUS CODE: " + code + " IS OUT OF RANGE <-- ");
        } else {
            try {
                URL url = new URL(catUrl);
                image = ImageIO.read(url);
                ImageIO.write(image, "jpg", new File("./catPics" + code
                        + extension));
                System.out.println("PICTURE WITH URL: " + url + " WAS DOWNLOADED <-- ");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(" -- Something went wrong !!! --- ");

            }
        }


    }

}
