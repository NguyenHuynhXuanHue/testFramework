package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    static Logger logger = LogManager.getLogger("testBookingFromHomePage");


    @BeforeMethod
    public void setupTest() {
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //chờ ngầm,kiểm tra tìm đến khi nào gặp, chờ 0.5s,đến 60s dừng. Dùng chung và khai báo 1 chỗ
        //Nếu set 360 thì thời gian chờ 1 test fail không hợp lý và KH không đợi để load trang
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demo1.cybersoft.edu.vn/");*/
        logger.info("Setting up WebDriver!!!");
        String browser = "chrome";
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.chromedriver().setup();
                driver = new FirefoxDriver();
                break;
            case "Egde":
                WebDriverManager.chromedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("This is");
        }
        //
    }
    public WebDriver getDriver(){
        return driver;
    }

}
