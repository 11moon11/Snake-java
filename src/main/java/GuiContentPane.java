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

    public GuiContentPane() {

    }
}
