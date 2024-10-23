package Sprint3.Swingtest.Layout;

import javax.swing.*;

public class GridLayout extends JFrame {
    JPanel panel = new JPanel();
    JLabel labelA = new JLabel("hej");
    JLabel labelB = new JLabel("lill-");
    JLabel labelC = new JLabel("råttan");
    JButton buttonA = new JButton("knapp");
    JButton buttonB = new JButton("tryckes på egen risk");

    public GridLayout() {

        this.add(panel);
        panel.add(labelA);
        panel.add(labelB);
        panel.add(labelC);
        panel.add(buttonA);
        panel.add(buttonB);

        panel.setLayout(new java.awt.GridLayout(3,2));


        setSize(500, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        GridLayout gl = new GridLayout();
    }
}
