package testgif;

import io.restassured.internal.ResponseSpecificationImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PageGif {

    WebDriver driver;

    public PageGif(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Women")
    WebElement wementab;
    @FindBy(css = "#block_top_menu > ul > li:nth-child(2) > a")
    WebElement dresstab;
    @FindBy(css = "#block_top_menu > ul > li:nth-child(3) > a")
    WebElement t_shirtstab;
    @FindBy(id = "selectProductSort")
    WebElement pricesort;
    @FindBy(css = "div.product-container")
    WebElement dress;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[1]/span")
    WebElement mouse;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement location;
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
    WebElement out;
    @FindBy(css = "#product_price_7_34_0.price")
    WebElement disc;




    public void isWemen() {
        boolean val = wementab.isDisplayed() && dresstab.isDisplayed() && t_shirtstab.isDisplayed();
        Assert.assertTrue(val, "not displayed");

    }

    public void dressClick() {
        dresstab.click();
    }

    public void lowestPrice() {
        Select sel = new Select(pricesort);
        sel.selectByValue("price:asc");
    }

    public void itemSize() {
        List<WebElement> list = driver.findElements(By.cssSelector("div.product-container"));

        int x = list.size();
        Assert.assertEquals(x, 5, "count doesn't match");

    }

    public Boolean avalableDress() {

        List<WebElement> list = driver.findElements(By.cssSelector("div.product-container"));
        int i ;
                    for (i = 0; i < list.size(); i++) {
                if (list.get(i).getText().contains("Printed Chiffon Dress") && list.get(i).getText().contains("In stock")) {

                return true;
                }
            }
                    return false;
    }
    public void bothAvalable(){
        Assert.assertTrue(avalableDress(), "no dress, no in stock field");
    }
    public void addtoCard() throws InterruptedException {

        Actions builder = new Actions(driver);
        Thread.sleep(5000);
        Action mouseOverHome =
                builder
                        .moveToElement(location)

                .moveToElement(mouse).click()
                .build();

        mouseOverHome.perform();

    }
    public void checkOut(){
        out.click();
    }
    public void disCount(){
       boolean z =  disc.getText().contains("-20%");

        Assert.assertTrue(z,   "not right discount");
    }

}

