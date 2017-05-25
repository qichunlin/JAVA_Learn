import javax.swing.*;
import java.awt.*;

/**
 * Created by OriginalS on 2017/2/8.
 */

public class UI {
    static public void main (String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                simpleUI ui = new simpleUI();
                ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                ui.setVisible(true);
            }
        });
    }
}

class simpleUI extends JFrame {
    public simpleUI() {
        setSize(500,600);
    }
}

