import gui.Gui;
import junit.framework.Assert;
import org.junit.Test;
import snake.Snake;

public class TestMain {
    @Test
    public void testPrintHelloWorld() {
        Gui gui = Gui.getInstance(600, 600, "Test", new Snake());
        Assert.assertNotNull(gui);
    }
}
