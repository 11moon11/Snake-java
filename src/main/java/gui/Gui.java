package gui; /**
 * Created by kiril on 14.03.2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {
    private static Gui instance = null;

    private Gui(int width, int height, String title, Drawable d) {
        System.out.println("gui.Gui is initializing...");
        JFrame window = new JFrame(title);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        GuiContentPane pane = new GuiContentPane();
        pane.setDrawable(d);

        window.setContentPane(pane);
        window.setSize(width, height);
        window.setVisible(true);
    }

    public static Gui getInstance(int w, int h, String title, Drawable d) {
        if(instance == null)
            instance = new Gui(w, h, title, d);

        return instance;
    }
}
