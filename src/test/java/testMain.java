import gui.Gui;
import junit.framework.Assert;
import org.junit.Test;

public class TestMain {
    @Test
    public void testPrintHelloWorld() {
        Gui gui = Gui.getInstance(600, 600);
        Assert.assertNotNull(gui);
    }
}
