package homeWork.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    String getStatusImage(int code) throws MalformedURLException {

        String catCodeUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(catCodeUrl);
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();


            if (status == 404) {
                throw new MalformedURLException("page not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return catCodeUrl;
    }
}


