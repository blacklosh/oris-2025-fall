package socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket socket = serverSocket.accept();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );

        writer.write("Welcome to my socket service! Whats your name?\n");
        writer.flush();

        String line = reader.readLine();
        System.out.println("Connected " + line);

        writer.close();
        reader.close();
        socket.close();
        serverSocket.close();
    }

}
