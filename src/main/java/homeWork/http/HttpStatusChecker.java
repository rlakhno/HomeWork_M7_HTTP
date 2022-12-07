package homeWork.http;

import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    String getStatusImage(int code) throws Exception {

        String catCodeUrl = "https://http.cat/" + code + ".jpg";
        URL url = new URL(catCodeUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        try {
            int status = connection.getResponseCode();
            if (status == 404) {
                catCodeUrl = "invalidStatus";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\n !!! --> There is NO image for HTTP status code : "
                    + code + " <-- ");
        }
        return catCodeUrl;

    }
}


