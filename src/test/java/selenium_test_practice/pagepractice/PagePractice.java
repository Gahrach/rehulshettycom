package selenium_test_practice.pagepractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PagePractice {

    WebDriver driver;

    @FindBy(name = "radioButton")
    WebElement newTours;
    @FindBy(id = "autocomplete")
    WebElement textbox;
    @FindBy(id = "dropdown-class-example")
    WebElement dropdown;
    @FindBy(id = "checkBoxOption3")
    WebElement checkbox;
    @FindBy(id = "openwindow")
    WebElement window;
    @FindBy(id = "alertbtn")
    WebElement alertelem;
    @FindBy(id = "confirmbtn")
    WebElement alertconf;
    @FindBy(linkText = "Open Tab")
    WebElement tab;
    @FindBy(linkText = "Register")
    WebElement home;
    @FindBy(id = "hide-textbox")
    WebElement hide;
    @FindBy(id = "show-textbox")
    WebElement show;
    @FindBy(id = "displayed-text")
    WebElement isdisptxtbox;
    @FindBy(id = "mousehover")
    WebElement hovermouse;
    @FindBy(css = "fieldset > div > div > a:nth-child(1)")
    WebElement topopt;
    @FindBy(css = "tbody > tr:nth-child(11) > td:nth-child(2)")
    WebElement textcopy;
    @FindBy(className = "tableFixHead")
    WebElement fixdown;


    public PagePractice(WebDriver driver) {           //constryctor
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clRadio() {
        List<WebElement> list = driver.findElements(By.name("radioButton"));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getAttribute("value").contains("radio3")) {
                list.get(i).click();
            }

        }

    }

    public void textBox(String text) {
        textbox.sendKeys(text);
    }

    public void drop(String text) {
        Select select = new Select(dropdown);
        select.selectByValue(text);
    }

    public void chBox() {
        if (!checkbox.isSelected()) {
            checkbox.click();

        }
    }

    public void windHandle() {
        window.click();
        Set<String> item = driver.getWindowHandles();
        for (String x : item) {


            if (driver.switchTo().window(x).getCurrentUrl().equals("http://www.qaclickacademy.com/")) {
                driver.close();
            }
        }
        for (String x : item) {
            if (driver.switchTo().window(x).getCurrentUrl().equals("https://rahulshettyacademy.com/AutomationPractice/")) {
                break;
            }
        }

    }

    public void alerTT() {
        alertelem.click();
        driver.switchTo().alert().accept();
    }

    public void alerDism() {
        alertconf.click();
        driver.switchTo().alert().dismiss();
    }

    public void openTab() {
        String parent = driver.getWindowHandle();
        System.out.println(parent + "    parent");
        tab.click();
        Set<String> handeles = driver.getWindowHandles();
        for (String child : handeles) {
            System.out.println(child);
            if (!handeles.equals(parent)) {
                driver.switchTo().window(child);
            }
        }
        //driver.close();
        driver.switchTo().window(parent);
    }

    public void isDisplayed() {
        //hide.click();
        if (isdisptxtbox.isDisplayed()) {
            isdisptxtbox.click();
            isdisptxtbox.sendKeys("with hide");
        } else {
            show.click();
            if (isdisptxtbox.isDisplayed()) {
                isdisptxtbox.click();
                isdisptxtbox.sendKeys("with show");
            }
        }
    }

    public void mouseHover() {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(hovermouse)
                .moveToElement(topopt)
                .click()
                .build();
        mouseOverHome.perform();

    }

    public void copyPaste() {
        List<WebElement> ll = driver.findElements(By.id("product"));
        String str = textcopy.getText();
        textbox.clear();
        textbox.sendKeys(str);

    }
    public void moveDown() {
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(fixdown).click()
                .sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN)

                .build();
        mouseOverHome.perform();
    }

}
