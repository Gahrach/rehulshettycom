package testgif;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestGif extends BaseGif {

    PageGif pagegif;

    @Test(priority = 1)
    public void testOne() throws InterruptedException {
        pagegif = new PageGif(driver);
        pagegif.isWemen();
        pagegif.dressClick();
        pagegif.lowestPrice();
        pagegif.itemSize();
        pagegif.bothAvalable();
        pagegif.addtoCard();
        pagegif.checkOut();
        pagegif.disCount();

    }
}
