package Base;

import Pages.HomePage;
import Pages.JavaScriptAlerts;
import Pages.LoginPage;
import Pages.SecureArea;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomePage homePage;
    public LoginPage loginPage;
    public SecureArea secureArea;
    public JavaScriptAlerts javaScriptAlerts;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        secureArea = new SecureArea(driver, wait);
        javaScriptAlerts = new JavaScriptAlerts(driver, wait);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
