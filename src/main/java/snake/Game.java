package snake;

import gui.Drawable;
import gui.Gui;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by kiril on 22.04.2017.
 */
public class Game implements Drawable {
    private Thread thread;
    private Snake snake;

    public Game() {
        Gui gui = Gui.getInstance(607, 601, "Snake game!", this);

        snake = new Snake(gui);
        thread = new Thread(snake);
        thread.start();
    }

    public void draw(Graphics g, int width, int height) {
        int tile = 40;

        int sizeX = width / tile;
        int sizeY = height / tile;

        // Draw field
        g.setColor(Color.RED);
        for(int x=0; x<sizeX; x++) {
            for(int y=0; y<sizeY; y++) {
                g.drawRect(x * tile, y * tile, tile, tile);
            }
        }

        snake.draw(g, width, height);
    }

    public void mouseClicked(int x, int y) {
        System.out.println("Mouse clicked at: X=" + x + " Y=" + y);
    }

    public void keyPressed(char key) {
        System.out.println("Key pressed: " + key);
        snake.update(key);
    }
}
