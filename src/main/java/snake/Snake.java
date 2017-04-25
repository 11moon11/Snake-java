package snake;

import gui.Drawable;
import gui.Gui;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by kiril on 22.04.2017.
 */
public class Snake implements Drawable {
    private List<SnakePart> snake;

    public Snake() {
        snake = new ArrayList<SnakePart>();
        snake.add(new SnakePart(1, 1, 40, 10));

        Gui gui = Gui.getInstance(622, 656, "Snake game!", this);
    }

    public void draw(Graphics g, int width, int height) {
        int tile = 40;

        int sizeX = width / tile;
        int sizeY = height / tile;

        g.setColor(Color.RED);
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                g.drawRect(x * tile, y * tile, tile, tile);
            }
        }

        for(SnakePart sp : snake) {
            sp.draw(g, width, height);
        }
    }

    public void mouseClicked(int x, int y) {
        System.out.println("Mouse clicked at: X=" + x + " Y=" + y);
    }

    public void keyPressed(char key) {
        System.out.println("Key pressed: " + key);
        snake.get(0).update(key);
    }
}
