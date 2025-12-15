package socket2.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatServer {

    public static List<Socket> clients = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        new Thread(ChatServer::acceptNewSockets).start();
    }

    public static void sendToAllClients(String message) {
        for(Socket socket : clients) {
            try {
                System.out.println("Sending response " + message);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write(message + "\n");
                writer.flush();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void readSocket(Socket socket) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (socket.isConnected()) {
                String line = reader.readLine();
                System.out.println("New message " + line);
                sendToAllClients(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Socket disconnected");
        clients.remove(socket);
    }

    public static void acceptNewSockets() {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            while (!serverSocket.isClosed()) {
                System.out.println("Waiting for connections...");
                Socket socket = serverSocket.accept();
                System.out.println("Connected new socket!");
                clients.add(socket);
                new Thread(() -> readSocket(socket)).start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
