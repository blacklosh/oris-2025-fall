package frame;

import panel.MyPanel;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 200, 800, 600);
        setTitle("Hello world");
        //setResizable(false);
        //setUndecorated(true);
        setContentPane(new MyPanel());
    }

}
