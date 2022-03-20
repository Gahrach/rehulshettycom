package colour_selenium_test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestColor extends BaseColor {
    PageColor color;

    @Test(priority = 1)
    public void Testss() {
        color = new PageColor(driver);
        color.setCol();
        color.oKK();
        Assert.assertTrue(color.greenCol(), "jgc");
        Assert.assertTrue(color.orangeCol2(), "right");
    }

}
