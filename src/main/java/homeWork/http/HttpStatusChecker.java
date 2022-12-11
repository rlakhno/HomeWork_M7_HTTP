package homeWork.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
  // new option for exception


    String getStatusImage(int code) {

        String catCodeUrl = "https://http.cat/" + code + ".jpg";
        try {
        URL url = new URL(catCodeUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status = connection.getResponseCode();


        if (status == 404) {
            throw new MalformedURLException("page not found");
        }
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
            System.out.println("PAGE NOT FOUND");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return catCodeUrl;
    }
}


