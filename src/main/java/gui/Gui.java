package gui; /**
 * Created by kiril on 14.03.2017.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Gui {
    private static Gui instance = null;
    private JFrame window;
    private int height;
    private int width;
    private int tile;

    private Gui(int width, int height) {
        System.out.println("gui.Gui is initializing...");
        window = new JFrame();
        this.height = height;
        this.width = width;
        tile = 40;

        window.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        window.setContentPane(new GuiContentPane());
        window.setSize(width, height);
        window.setVisible(true);
        //drawTiles();
    }

    private void drawTiles() {
        int sizeX = width / tile;
        int sizeY = height / tile;
        Graphics g = window.getGraphics();

        g.setColor(Color.RED);
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                g.drawRect(x * tile, y * tile, sizeX, sizeY);
            }
        }
    }

    public static Gui getInstance(int w, int h) {
        if(instance == null)
            instance = new Gui(w, h);

        return instance;
    }
}
