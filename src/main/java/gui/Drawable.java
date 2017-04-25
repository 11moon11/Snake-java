package gui;

import java.awt.*;

/**
 * Created by kiril on 24.04.2017.
 */
public interface Drawable {
    public void draw(Graphics g, int width, int height);
    public void mouseClicked(int x, int y);
    public void keyPressed(char key);
}
