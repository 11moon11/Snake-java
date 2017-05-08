package snake;

import java.awt.*;

/**
 * Created by kiril on 07.05.2017.
 */
public class Food {
    private Point point;
    private int partSize;

    public Food(Point p, int size) {
        point = p;
        partSize = size;
    }

    public Point getPosition() {
        return point;
    }

    public void relocate(int x, int y) {
        point = new Point(x, y);
    }

    public void draw(Graphics g, int width, int height) {
        g.setColor(Color.GREEN);
        g.fillRect((int)point.getX() * partSize, (int)point.getY() * partSize, partSize, partSize);
    }
}
