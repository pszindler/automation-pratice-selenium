package pageObjects;

import driver.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BasePO{

    public BasePO() {
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void getManager() {
        DriverFactory.createWebDriverManager();
    }

    public void navigateToURL(String url) {
        getManager();
        getDriver().get(url);
    }
}
