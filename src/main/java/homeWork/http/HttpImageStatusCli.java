package homeWork.http;

import java.util.Scanner;

public class HttpImageStatusCli {

    void askStatus() throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("PLEASE ENTER HTTP STATUS CODE OR QUIT TO EXIT");

        while (scanner.hasNext()) {

            if (scanner.hasNextInt()) {

                new HttpStatusImageDownloader().downloadStatusImage(scanner.nextInt());
                System.out.println("PLEASE ENTER HTTP STATUS CODE OR QUIT TO EXIT");

            } else if (scanner.next().equals("QUIT")) {
                scanner.close();
                System.out.println("GOODBYE...");
                break;
            } else {
                System.out.println("PLEASE ENTER A VALID NUMBER");
                askStatus();
            }

        }
    }
}
