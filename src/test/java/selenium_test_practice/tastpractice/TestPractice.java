package selenium_test_practice.tastpractice;

import org.testng.annotations.Test;
import selenium_test_practice.basepractice.BasePractice;
import selenium_test_practice.pagepractice.PagePractice;

public class TestPractice extends BasePractice {


    PagePractice practice;

    @Test(priority = 1)
    public void radPractice() {
        practice = new PagePractice(driver);
        practice.clRadio();
    }


    @Test(priority = 2)
    public void txBox() {
        practice = new PagePractice(driver);
        practice.textBox("something");
    }

    @Test(priority = 3)
    public void dropDwn() {
        practice = new PagePractice(driver);
        practice.drop("option3");
    }

    @Test(priority = 4)
    public void chBox() {
        practice = new PagePractice(driver);
        practice.chBox();
    }

    @Test(priority = 5)
    public void windHandle() {
        practice = new PagePractice(driver);
        practice.windHandle();


    }

    @Test(priority = 6)
    public void tabSwitch() {
        practice = new PagePractice(driver);
        practice.openTab();

    }

    @Test(priority = 7)
    public void alLLert() {
        practice = new PagePractice(driver);
        practice.alerTT();
    }


    @Test(priority = 8)
    public void dismissAlert() {
        practice = new PagePractice(driver);
        practice.alerDism();

    }

    @Test(priority = 9)
    public void Displayed() {
        practice = new PagePractice(driver);
        practice.isDisplayed();
    }

    @Test(priority = 10)
    public void Hover() {
        practice = new PagePractice(driver);
        practice.mouseHover();
    }

    @Test(priority = 11)
    public void copy() {
        practice = new PagePractice(driver);
        practice.copyPaste();
    }

    @Test(priority = 12)
    public void rollD() {
        practice = new PagePractice(driver);
        practice.moveDown();
    }
}