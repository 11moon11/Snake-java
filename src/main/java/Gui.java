/**
 * Created by kiril on 14.03.2017.
 */
import java.awt.event.*;
import javax.swing.*;

public class Gui {
    private static Gui instance = null;

    protected Gui(int width, int hight) {
        System.out.println("Gui is initializing...");
        JFrame f = new JFrame();
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setContentPane(new GuiContentPane());
        f.setSize(width, hight);
        f.setVisible(true);
    }

    public static Gui getInstance(int w, int h) {
        if(instance == null)
            instance = new Gui(w, h);

        return instance;
    }
}
