package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by kiril on 14.03.2017.
 */
public class GuiContentPane extends JPanel {
    private Graphics graph;

    String[] type = { "Serif","SansSerif"};
    int[] styles = { Font.PLAIN, Font.ITALIC, Font.BOLD, Font.ITALIC + Font.BOLD };
    String[] stylenames = { "Plain", "Italic", "Bold", "Bold & Italic" };

    /*
    public void paint(Graphics g) {
        graph = g;
        for (int f = 0; f < type.length; f++) {
            for (int s = 0; s < styles.length; s++) {
                Font font = new Font(type[f], styles[s], 18);
                g.setFont(font);
                String name = type[f] + " " + stylenames[s];
                g.drawString(name, 20, (f * 4 + s + 1) * 20);
            }
        }
    }
    */

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTiles(g);
    }

    private void drawTiles(Graphics g) {
        int tile = 40;
        int width = super.getWidth();
        int height = super.getHeight();

        int sizeX = width / tile;
        int sizeY = height / tile;

        g.setColor(Color.RED);
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                g.drawRect(x * tile, y * tile, tile, tile);
            }
        }
    }

    public GuiContentPane() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
