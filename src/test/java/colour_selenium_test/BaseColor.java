package colour_selenium_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseColor {
    public WebDriver driver;
    private String baseUrl = "https://www.w3schools.com/colors/colors_picker.asp";

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromedriverSelenium\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        options.getLogLevel();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        // driver.quit();
    }
}

