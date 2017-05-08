package gui;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * Created by kiril on 14.03.2017.
 */
public class GuiContentPane extends JPanel implements MouseListener, KeyListener {
    private Drawable plane;

    public GuiContentPane() {
        super();

        setBorder(BorderFactory.createLineBorder(Color.black));
        plane = new DrawableStub();
        addMouseListener(this);
        addKeyListener(this);
    }

    public void paint(Graphics g) {
        int height = getSize().height;
        int width = getSize().width;

        if(width == 0 || height == 0)
            return;

        // Double buffering
        Image imageBuffer = createImage(width, height);
        Graphics gIB = imageBuffer.getGraphics();

        gIB.setColor(Color.white);
        gIB.fillRect(0, 0, width, height);

        if(plane != null)
            plane.draw(gIB, width, height);

        // copy the imageBuffer to the plane
        g.drawImage(imageBuffer, 0, 0, null);
        requestFocus();
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null)
            plane = drawable;
    }

    public void mousePressed (MouseEvent event) {
        //repaint();

        if (plane != null)
            plane.mouseClicked(event.getX(), event.getY());

        //repaint();
        requestFocus();  //needed to get the key presses to work
    }

    public void keyTyped(KeyEvent ke) {
        //repaint();

        char key = ke.getKeyChar();

        if (plane != null)
            plane.keyPressed(key);

        //repaint();
    }

    public void updateFrame() {
        repaint();
        paint(getGraphics());
        repaint();
    }

    public void mouseClicked (MouseEvent event){}
    public void mouseReleased (MouseEvent event){}
    public void mouseEntered (MouseEvent event){}
    public void mouseExited (MouseEvent event){}
    public void keyPressed(KeyEvent ke){}
    public void keyReleased(KeyEvent ke){}
}
