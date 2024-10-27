package Sprint3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pics extends JFrame implements ActionListener {

    String imagePath1 = "src/Manet/ea7e6be1ec56573b3919263002765285.jpg";
    String imagePath2 = "src/Manet/Jelly_cloud_horizontal_900.jpg";
    String imagePath3 = "src/Manet/Sea-Nettle.jpg";

    JPanel panel;
    JLabel imageLabel;
    JButton button;

    int toggler = 0;

    public Pics(){

        panel = new JPanel();

        button = new JButton(" Växla bild ");
        button.setBackground(Color.PINK);
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));

        imageLabel = new JLabel(new ImageIcon(imagePath1));
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.PINK, 3));
        imageLabel.setPreferredSize(new Dimension(800, 500));


//        button.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                //Todo
//            }
//        });

        panel.setLayout(new java.awt.BorderLayout());
        panel.setBackground(Color.PINK);
        panel.add(imageLabel, java.awt.BorderLayout.CENTER);
        panel.add(button, java.awt.BorderLayout.SOUTH);
        this.add(panel);
        button.addActionListener(this);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (toggler == 0){
            imageLabel.setIcon(new ImageIcon(imagePath2));
            toggler = 1;
        }else if (toggler == 1){
            imageLabel.setIcon(new ImageIcon(imagePath3));
            toggler = 2;
        }else if (toggler == 2){
            imageLabel.setIcon(new ImageIcon(imagePath1));
            toggler = 0;
        }
    }
    public static void main(String[] args) {Pics pics = new Pics();}
}
