package Sprint3.Swingtest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Livekod extends JFrame implements ActionListener {

    JPanel bas = new JPanel();
    JPanel panelCenter = new JPanel();
    JPanel panelNorth = new JPanel();
    JPanel panelSouth = new JPanel();
    JPanel panelWest = new JPanel();
    JPanel panelEast = new JPanel();

    JLabel label;

    JButton buttonA;
    JButton buttonB;

    public Livekod() {

        bas.setLayout(new java.awt.BorderLayout());
        add(bas);

        bas.add(panelCenter, BorderLayout.CENTER);
        bas.add(panelNorth, BorderLayout.NORTH);
        bas.add(panelSouth, BorderLayout.SOUTH);
        bas.add(panelWest, BorderLayout.WEST);
        bas.add(panelEast, BorderLayout.EAST);

        buttonA = new JButton("Eat Me");
        buttonA.setBackground(Color.PINK);
        buttonA.setForeground(Color.WHITE);
        buttonA.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        buttonA.addActionListener(this);

        buttonB = new JButton("Drink Me");
        buttonB.setBackground(Color.PINK);
        buttonB.setForeground(Color.WHITE);
        buttonB.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
        buttonB.addActionListener(this);

        panelSouth.add(buttonA, BorderLayout.SOUTH);
        panelNorth.add(buttonB, BorderLayout.NORTH);

        label = new JLabel("Curiouser and curiouser!");
        label.setForeground(Color.PINK);
        panelCenter.add(label, BorderLayout.CENTER);

        setTitle("Swingdemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setSize(500, 500);
        pack();
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonA) {
            JOptionPane.showMessageDialog(null,"Oh Alice! You're so big!");
        } else if (e.getSource() == buttonB) {
            JOptionPane.showMessageDialog(null,"Poor Alice, as small as a mouse!");
        }
    }
    public static void main(String[] args) {
        Livekod livekod = new Livekod();
    }
}
