package selenium_test_autoam.pageAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PageAuto {

    WebDriver driver;


    @FindBy(css = "div > div.a4bIc > input")
    WebElement autoam;

    @FindBy(css = "cite[role='text']:nth-child(1)")
    WebElement cite;
    @FindBy(css = "#filter-make")
    WebElement make;
    @FindBy(css = "#home-filters > div:nth-child(3) > label:nth-child(1) > select")
    WebElement year;
    @FindBy(css = "#v-model")
    WebElement model;
    @FindBy(css = ".home-filters-switch > div:nth-child(1)")
    WebElement checkboxmax;
    @FindBy(id = "search-btn")
    WebElement search;
    @FindBy(css = "div[class ^= 'pad-top-6 pad-bot-6 makeflex makebetween']")
    WebElement resultcount;

     @FindBy(id = "search-cont")
     WebElement resultprice;


    public void goautoam() {
        autoam.sendKeys("Auto.am");
        autoam.submit();
    }

    public void citeClick() {
        cite.click();
    }


    public PageAuto(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkAutoamTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title, "Title not match!!!");

    }

    public void selectMake(String itemToSelect) {
        Select select = new Select(make);
        select.selectByVisibleText(itemToSelect);
    }
    public void selectYear(String itemToSelect) {
        Select select = new Select(year);
        select.selectByVisibleText(itemToSelect);
    }
    public void selectModel(String itemToSelect) {
        Select select = new Select(model);
        select.selectByVisibleText(itemToSelect);
    }
    public void clickCheckbox() {
        if (checkboxmax.isSelected()) {
            System.out.println("selected");
        }else {
            checkboxmax.click();
        }
    }
    public void clickSearch() {
        search.click();
    }

    public  void  searchResultCount(String ttext) {
        List<WebElement> sel = driver.findElements(By.cssSelector("div[class ^= 'pad-top-6 pad-bot-6 makeflex makebetween']"));
        for (int i = 0; i < sel.size(); i++) {

            boolean x = sel.get(i).getText().contains(ttext);
        //    System.out.println(sel.get(i).getText());
            Assert.assertTrue(x, "not found ");

        }
        System.out.println(sel.size() + " found cars");

    }
    public void price(String price) {
        List<WebElement> sel = driver.findElements(By.id("search-cont"));
        for (int i = 0; i < sel.size(); i++) {

            boolean p = sel.get(i).getText().contains(price);
          //  System.out.println(sel.get(i).getText());
            Assert.assertTrue(p, "not found ");

        }
        System.out.println(sel.size() + " match price");


    }
}