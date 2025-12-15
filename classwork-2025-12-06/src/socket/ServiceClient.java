package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServiceClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8081);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );

        String line = reader.readLine();
        System.out.println("Welcome message: " + line);

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        writer.write(name);
        writer.flush();

        writer.close();
        reader.close();
        socket.close();
    }

}
