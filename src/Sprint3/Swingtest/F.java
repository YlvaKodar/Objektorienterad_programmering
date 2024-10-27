package Sprint3.Swingtest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class F extends JFrame {

    protected JPanel panel = new JPanel();
    protected JButton button1 = new JButton("Button1");
    protected JButton button2 = new JButton("Button2");
    protected JTextField första = new JTextField(10);

    public F() {

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(wa);

        första.addFocusListener(fl);

        panel.add(button1);
        panel.add(button2);
        panel.add(första);
        add(panel);

        pack();
    }
    protected WindowAdapter wa = new WindowAdapter() {
        @Override
        public void windowActivated(WindowEvent e) {
            första.requestFocus();
        }
    };
    protected FocusListener fl = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            första.setBackground(Color.CYAN);
        }

        @Override
        public void focusLost(FocusEvent e) {
            första.setBackground(Color.WHITE);
        }
    };
    public static void main(String[] args) {F f = new F(); }
}
