package Sprint3.Swingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseLis extends JFrame implements MouseListener {


    JPanel panel = new JPanel();
    JButton button = new JButton("Click Me");
    //Muslyssnare kan kopplas och gör knappen röd

    public MouseLis() {

        button.addMouseListener(this);
        button.setForeground(Color.PINK);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));
        button.setMargin(new Insets(20, 20, 20, 20));
        panel.add(button);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.add(panel);
        pack();

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        button.setBackground(Color.PINK);
        button.setForeground(Color.red);
        button.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        button.setText("Peekaboo!");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        button.setText("Click Me");
        button.setForeground(Color.PINK);
        button.setBackground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.PINK, 2));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        button.setBackground(Color.red);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        button.setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        MouseLis ml = new MouseLis();
    }
}
