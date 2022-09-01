import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Log;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class BaseTest {
    protected WebDriver driver;
    protected TestInfo testInfo;
    ChromeOptions chromeOptions = new ChromeOptions();

    public BaseTest() {
        Log.classThreadDebug(BaseTest.class);
    }

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        Log.info("WebDriverManager initialized");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Log.info("WebDriver Selenium logLevel=0, ChromeDriverService=silent_output_mode");
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        this.testInfo = testInfo;
        Log.info(chromeOptions.getBrowserName() + chromeOptions.getBrowserVersion());
        List<String> chromeArgs = Arrays.asList("--headless", "--disable-gpu",
                "--window-size=1920,1200", "--ignore-certificate-errors",
                "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        chromeOptions.addArguments(chromeArgs);
        driver = new ChromeDriver(chromeOptions);
        Log.info("Driver started with chromeOptions");
        Log.debug("ChromeOptions Arguments: " + chromeArgs);
    }

    @AfterEach
    void teardown() {
        Log.info("Selenium Web driver shutdown attempt...");
        try {
            driver.quit();
            Log.seleniumThreadExitDebug();
        } catch (Exception e) {
            Log.warn("Selenium Web driver has not been closed!!! : " + e);
        }
    }
}
