package testgif;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseGif {

    WebDriver driver;
    String URL  = "http://automationpractice.com/index.php";
    @BeforeClass
    public void setUp(){
         System.setProperty("webdriver.chrome.driver","C:\\ChromedriverSelenium\\chromedriver_win32\\chromedriver.exe");
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
         driver.manage().window().maximize();
         driver.get(URL);

    }
    @AfterClass
    public void tearDown(){
    driver.quit();
    }
}
