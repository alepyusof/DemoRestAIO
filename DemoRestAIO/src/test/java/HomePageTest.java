//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//import java.io.File;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import com.demo.utility.JiraCreateIssue;
//
//public class HomePageTest {
//    private WebDriver driver;
//
//    private String baseUrl;
//
//    @BeforeClass(alwaysRun = true)
//    public void setUp() throws Exception {
//
//        File chromedriverExecutable = new File("driver/chromedriver.exe");
//
//        System.setProperty("webdriver.chrome.driver", chromedriverExecutable.getAbsolutePath());
//
//        driver = new ChromeDriver();
//
//        baseUrl = "https://www.browserstack.com/";
//
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//    }
//
//}
