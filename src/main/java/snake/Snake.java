package snake;

import gui.Gui;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Random;

/**
 * Created by kiril on 07.05.2017.
 */
public class Snake implements Runnable {
    private List<SnakePart> snake;
    private volatile boolean stop;
    private Random rnd;
    private Food food;
    private int sizeX;
    private int sizeY;
    private int life;
    private Gui gui;

    public Snake(Gui gui) {
        life = 1;
        this.gui = gui;
        this.stop = false;
        rnd = new Random();
        snake = Collections.synchronizedList(new ArrayList<SnakePart>());
        food = new Food(new Point(5, 5), 40);
        snake.add(new SnakePart(1, 1, 40, life, 'v'));
    }

    public void tick() {
        SnakePart newPart = null;

        for(int i=0; i<snake.size(); i++) {
            if(snake.get(i).update()) {
                snake.remove(i);
                i--;
            }
        }

        for(SnakePart sp : snake) {
            if(sp.tick()) {
                life++;
                newPart = sp.copyCurrent(life);
                food.relocate(rnd.nextInt(sizeX), rnd.nextInt(sizeY));
            }
        }

        if(newPart != null) {
            snake.add(newPart);
        }

        SnakePart newHead = snake.get(0).nextHead(life);
        newHead.setFood(food);

        snake.add(0, newHead);
    }

    public void draw(Graphics g, int width, int height) {
        sizeX = width / 40;
        sizeY = height / 40;

        food.draw(g, width, height);

        for(SnakePart aSnake : snake) {
            aSnake.draw(g, width, height);
        }
    }

    public void update(char key) {
        for(SnakePart aSnake : snake) {
            aSnake.update(key);
        }
    }

    public void run() {
        while(!stop) {
            gui.updateFrame();
            tick();
            gui.updateFrame();
            try {
                Thread.sleep(100);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
