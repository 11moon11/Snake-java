package snake;

import java.awt.*;

/**
 * Created by kiril on 22.04.2017.
 */
public class SnakePart {
    private int partSize;
    private Food food;
    private int posX;
    private int posY;
    private char dir;
    private int life;

    public SnakePart(int x, int y, int size, int life, char key) {
        this.life = life;
        partSize = size;
        food = null;
        dir = key;
        posX = x;
        posY = y;
    }

    public void draw(Graphics g, int width, int height) {
        g.setColor(Color.RED);
        g.fillRect(posX * partSize, posY * partSize, partSize, partSize);
    }

    private Point getNextPosition() {
        Point p = new Point(posX, posY);

        if(dir == 'w')
            p.setLocation(p.getX(), p.getY() - 1);
        else if(dir == 's')
            p.setLocation(p.getX(), p.getY() + 1);
        else if(dir == 'd')
            p.setLocation(p.getX() + 1, p.getY());
        else if(dir == 'a')
            p.setLocation(p.getX() - 1, p.getY());

        return p;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public boolean tick() {
        if(food != null) {
            Point fPoint = food.getPosition();
            if(fPoint.getY() == posY && fPoint.getX() == posX) {
                return true;
            }
        }

        if(life > 0)
            life--;

        return false;
    }

    public void update(char key) {
        // Prohibit to change direction 180 degrees
        if((dir == 'a' && key == 'd') || (dir == 'd' && key == 'a'))
            return;
        if((dir == 'w' && key == 's') || (dir == 's' && key == 'w'))
            return;

        dir = key;
    }

    public boolean update() {
        return life == 0;
    }

    public SnakePart nextHead(int lfe) {
        Point p = getNextPosition();

        SnakePart newHead = new SnakePart((int)p.getX(), (int)p.getY(), partSize, lfe, dir);

        return newHead;
    }

    public SnakePart copyCurrent(int lfe) {
        return new SnakePart(posX, posY, partSize, lfe, dir);
    }
}
