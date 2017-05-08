import gui.Gui;
import org.junit.Test;
import snake.Game;
import static org.junit.Assert.*;

public class TestMain {
    @Test
    public void testPrintHelloWorld() {
        Gui gui = Gui.getInstance(600, 600, "Test", new Game());
        assertNotNull(gui);
    }
}
