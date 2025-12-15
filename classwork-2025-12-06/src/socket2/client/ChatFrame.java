package socket2.client;

import javax.swing.*;
import java.awt.*;

public class ChatFrame extends JFrame {

    private JTextArea textArea;

    private JTextField textField;

    private JButton button;

    private ChatService chatService;

    private final Font font = new Font("arial", Font.BOLD, 50);

    public ChatFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLayout(null);
        setTitle("MyChat");

        textArea = new JTextArea();
        textArea.setBounds(0, 100, 600, 500);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setEditable(false);
        add(textArea);

        textField = new JTextField();
        textField.setBounds(0, 0, 400, 90);
        textField.setEditable(true);
        textField.setFont(font);
        add(textField);

        button = new JButton(">>>");
        button.setBounds(420, 0, 150, 90);
        button.addActionListener(e -> {
            String line = textField.getText();
            textField.setText("");
            sendMessage(line);
        });
        button.setFont(font);
        add(button);
    }

    public void setChatService(ChatService s) {
        chatService = s;
    }

    private void sendMessage(String message) {
        chatService.sendMessage(message);
    }

    public void addNewText(String message) {
        String text = textArea.getText();
        text = text + "\n" + message;
        textArea.setText(text);
    }

}
