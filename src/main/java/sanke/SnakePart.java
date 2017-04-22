package sanke;

import java.awt.*;

/**
 * Created by kiril on 22.04.2017.
 */
public class SnakePart {
    private int partSize;
    private int posX;
    private int posY;
    private int life;

    public SnakePart(int x, int y, int size, int ticks) {
        partSize = size;
        life = ticks;
        posX = x;
        posY = y;
    }

    public void draw(Graphics g) {

    }
}
