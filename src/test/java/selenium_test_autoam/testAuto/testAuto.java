package selenium_test_autoam.testAuto;

import org.testng.annotations.Test;
import selenium_test_autoam.baseAuto.baseAuto;
import selenium_test_autoam.pageAuto.PageAuto;


public class testAuto extends baseAuto {
    PageAuto autotest;

@Test(priority = 1)
    public void Page() {
        autotest = new PageAuto(driver);
        autotest.goautoam();
        autotest.citeClick();
        autotest.checkAutoamTitle("Ավտոմեքենաների վաճառք Հայաստանում - Auto.am");
        autotest.selectMake("Tesla");
        autotest.selectYear("2018");
        autotest.selectModel("Model Y");
        autotest.clickCheckbox();
        autotest.clickSearch();
        autotest.searchResultCount("Tesla");
        autotest.price("$ 67 000");
    }
}