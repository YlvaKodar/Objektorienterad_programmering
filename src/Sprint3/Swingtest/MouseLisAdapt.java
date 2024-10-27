package Sprint3.Swingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class MouseLisAdapt extends JFrame {

    JPanel panel = new JPanel();
    JButton button = new JButton("Click Me");

    public MouseLisAdapt() {
        button.setForeground(Color.PINK);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));
        button.setMargin(new Insets(20, 20, 20, 20));

        button.addMouseListener(new MouseAdapt());

        panel.add(button);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.add(panel);
        pack();

    }

    public static void main(String[] args) {
        Sprint3.Swingtest.MouseLisAdapt ml = new Sprint3.Swingtest.MouseLisAdapt();
    }
}
