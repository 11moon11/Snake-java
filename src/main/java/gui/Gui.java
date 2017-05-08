package gui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Created by kiril on 14.03.2017.
 */
public class Gui {
    private static Gui instance = null;
    private static GuiContentPane pane;

    private Gui(int width, int height, String title, Drawable d) {
        System.out.println("gui.Gui is initializing...");
        JFrame window = new JFrame(title);

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        pane = new GuiContentPane();
        pane.setDrawable(d);


        window.setVisible(true);
        window.setResizable(false);
        window.setSize(width, height);
        window.add(pane, BorderLayout.CENTER);
    }

    public void updateFrame() {
        pane.updateFrame();
    }

    public static Gui getInstance(int w, int h, String title, Drawable d) {
        if(instance == null)
            instance = new Gui(w, h, title, d);

        return instance;
    }
}
