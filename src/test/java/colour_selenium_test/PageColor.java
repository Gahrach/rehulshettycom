package colour_selenium_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageColor {
    WebDriver driver;

    @FindBy(id = "entercolor")
    WebElement textb;
    @FindBy(css = "#entercolorDIV > button")
    WebElement okk;
    @FindBy(css = "#huecontainer tr")
    WebElement greenblok;


    public PageColor(WebDriver driver) {           //constryctor
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCol() {
        textb.sendKeys("#ff9900");

    }

    public void oKK() {
        okk.click();
    }

    public boolean greenCol() {
        List<WebElement> list = driver.findElements(By.cssSelector("#huecontainer tr"));

        for (WebElement y : list) {

            if (y.getAttribute("class").equals("ws-green")) {
                //   String s = y.getAttribute("class");
                //   System.out.println(s);
                return true;

            }

        }
        return false;


    }

    public boolean orangeCol2() {
        List<WebElement> list = driver.findElements(By.cssSelector("#huecontainer tr.ws-green>td"));

        for (WebElement x : list) {

            if (x.getAttribute("style").contains("background-color: rgb(255, 153, 0)")) {
                String s = x.getAttribute("style");
                System.out.println(s);

                return true;

            }

        }
        return false;
    }
}










