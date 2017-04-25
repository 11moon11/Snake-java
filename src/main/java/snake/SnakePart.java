package snake;

import gui.Drawable;

import java.awt.*;

/**
 * Created by kiril on 22.04.2017.
 */
public class SnakePart {
    private int movement;
    private int partSize;
    private int posX;
    private int posY;
    private int life;


    public SnakePart(int x, int y, int size, int ticks) {
        partSize = size;
        life = ticks;
        movement = 0;
        posX = x;
        posY = y;
    }

    public void draw(Graphics g, int width, int height) {
        int sizeX = width / partSize;
        int sizeY = height / partSize;

        g.fillRect(posX * partSize, posY * partSize, partSize, partSize);
    }

    public void update(char key) {
        if(key == 'w')
            posY--;
        else if(key == 's')
            posY++;
        else if(key == 'd')
            posX++;
        else if(key == 'a')
            posX--;
    }
}
