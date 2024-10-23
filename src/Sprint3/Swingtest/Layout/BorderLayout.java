package Sprint3.Swingtest.Layout;
import javax.swing.*;

//Fönstret delas in i fel delar: North, South, East, West, Center
public class BorderLayout extends JFrame {
    JPanel panel = new JPanel();
    JPanel south  = new JPanel();
    JPanel north  = new JPanel();
    JPanel west  = new JPanel();
    JPanel east  = new JPanel();

    JLabel labelA = new JLabel("hej");
    JLabel labelB = new JLabel("lill-");
    JLabel labelC = new JLabel("råttan");
    JButton buttonA = new JButton("knapp");
    JButton buttonB = new JButton("tryckes på egen risk");

    public BorderLayout() {

        this.add(panel);
        panel.setLayout(new java.awt.BorderLayout());
        panel.add(south, java.awt.BorderLayout.SOUTH);
        panel.add(north, java.awt.BorderLayout.NORTH);
        panel.add(west, java.awt.BorderLayout.WEST);
        panel.add(east, java.awt.BorderLayout.EAST);

        south.setLayout(new java.awt.FlowLayout());
        west.setLayout(new java.awt.GridLayout(3, 1));
        west.add(labelA);
        west.add(labelB);
        west.add(labelC);

        north.add(buttonA);
        south.add(buttonB);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        BorderLayout bL = new BorderLayout();
    }
}
