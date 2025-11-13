package panel;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyPanel extends JPanel {

    private final Font defaultFont = new Font("arial", Font.BOLD, 35);

    private final JCheckBox checkBox = new JCheckBox();

    public MyPanel() {
        setBackground(new Color(128, 0, 23));

        setLayout(null);

        JButton button1 = new JButton();
        button1.setText("Click me!");
        button1.setBounds(150, 150, 200, 60);
        button1.setBackground(Color.GREEN);
        button1.setFont(defaultFont);
        button1.setForeground(Color.WHITE);
        button1.addActionListener(e -> {
            Random random = new Random();
            setBackground(new Color(random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)));
            checkCheckBox();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });
        add(button1);

        JLabel label1 = new JLabel();
        label1.setText("Ahahahahhahahaa");
        label1.setFont(defaultFont);
        label1.setForeground(Color.CYAN);
        label1.setBounds(0, 0, 400, 50);
        add(label1);

        checkBox.setText("Select me!");
        checkBox.setFont(defaultFont);
        checkBox.setForeground(Color.CYAN);
        checkBox.setBounds(0, 60, 400, 50);
        checkBox.setBackground(Color.DARK_GRAY);
        checkBox.setSelected(true);
        add(checkBox);

        JTextArea textField = new JTextArea();
        textField.setBounds(400, 400, 300, 150);
        textField.setFont(defaultFont);
        add(textField);
    }

    private void checkCheckBox() {
        if(checkBox.isSelected()) {
            System.out.println("УРА ПОЛЬЗОВАТЕЛЬ ЗАБЫЛ НАЖАТЬ");
        } else {
            System.out.println("ЭЭЭЭХ ОН ЗАМЕТИЛ(((((");
        }
    }
}
