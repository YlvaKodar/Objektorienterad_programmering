package Sprint3.Layout;
import javax.swing.*;

public class FlowLayout extends JFrame {
    JPanel panel = new JPanel();
    JLabel labelA = new JLabel("hej");
    JLabel labelB = new JLabel("lill-");
    JLabel labelC = new JLabel("råttan");
    JButton buttonA = new JButton("knapp");
    JButton buttonB = new JButton("tryckes på egen risk");

    public FlowLayout() {

        this.add(panel);
        panel.add(labelA);
        panel.add(labelB);
        panel.add(labelC);
        panel.add(buttonA);
        panel.add(buttonB);

        panel.setLayout(new java.awt.FlowLayout());

        setSize(500, 100);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        FlowLayout frame = new FlowLayout();
    }
}

