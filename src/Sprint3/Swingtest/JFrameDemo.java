package Sprint3.Swingtest;
import javax.swing.*;

public class JFrameDemo extends JFrame { //G¨nra att istället skapa upp ett objekt av JFrame jfr = new JFrame();

    public JFrameDemo() {

        setSize(100, 100); //pack(); blir lika stor som komponenterna
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        JFrameDemo jFrame = new JFrameDemo();
    }
}
