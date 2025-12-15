package socket2.client;

import javax.swing.*;

public class ChatClient {

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Whats your name?");
        ChatFrame frame = new ChatFrame();
        ChatService service = new ChatService(frame, name);
        frame.setChatService(service);
        frame.setVisible(true);
    }
}
