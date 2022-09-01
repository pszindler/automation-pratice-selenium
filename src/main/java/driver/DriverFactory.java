package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void createWebDriverManager() {

        switch (getBrowserType()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
            }
        }
    }
    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                List<String> chromeArgs = Arrays.asList("--headless", "--disable-gpu",
                        "--window-size=1920,1200", "--ignore-certificate-errors",
                        "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
                chromeOptions.addArguments(chromeArgs);
                driver = new ChromeDriver(chromeOptions);
            }
            case "firefox" -> {
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
            }
        }
        return driver;
    }

    private static String getBrowserType() {
        String browserType = null;

        try {
            Properties properties = new Properties();
            File file = new File("src/main/java/properties/config.properties");
            FileInputStream isr = new FileInputStream(file);
            properties.load(isr);
            browserType = properties.getProperty("browserType").toLowerCase().trim();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return browserType;
    }

    public static void cleanUp() {
        webDriver.get().quit();
        webDriver.remove();
    }
}
