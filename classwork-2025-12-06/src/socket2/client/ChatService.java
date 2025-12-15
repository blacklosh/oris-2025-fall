package socket2.client;

import java.io.*;
import java.net.Socket;

public class ChatService {

    private Socket socket;

    private ChatFrame frame;

    private String name;

    private BufferedWriter writer;

    private BufferedReader reader;

    public ChatService(ChatFrame frame, String name) {
        this.frame = frame;
        this.name = name;
        try {
            socket = new Socket("127.0.0.1", 1234);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            throw new IllegalArgumentException("No connection!");
        }
        new Thread(this::readMessages).start();
    }

    public void sendMessage(String line) {
        try {
            String msg = "[" + name + "]: " + line + "\n";
            System.out.println("Sending message " + msg);
            writer.write(msg);
            writer.flush();
        } catch (IOException e) {
            System.err.println("Send message error:" + e.getMessage());
        }
    }

    private void readMessages() {
        while (socket.isConnected()) {
            try {
                String line = reader.readLine();
                System.out.println("New message: " + line);
                frame.addNewText(line);
            } catch (IOException e) {
                System.err.println("Read message error: " + e.getMessage());
            }
        }
    }

}
