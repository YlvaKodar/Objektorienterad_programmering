package Sprint3.Swingtest;

import javax.swing.*;
import java.awt.*;

public class ComponentDemo extends JFrame {




    JPanel panel = new JPanel();
    JLabel label = new JLabel("hej!");
    JButton button = new JButton("knapp");

    public ComponentDemo() {

        button.setBackground(Color.PINK);
        button.setForeground(Color.BLACK);

        //button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        //button.setBorder(BorderFactory.createEmptyBorder());
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        button.setMargin(new Insets(10, 10, 10, 10));

        button.setOpaque(true);

        this.add(panel);
        panel.add(label);
        panel.add(button);

        setSize(500, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        ComponentDemo cD = new ComponentDemo();
    }
}
