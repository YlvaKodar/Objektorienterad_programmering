package Sprint3.Swingtest;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseAdapt extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Peekaboo!");
    }
}
