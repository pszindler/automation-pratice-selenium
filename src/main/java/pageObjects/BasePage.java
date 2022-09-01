package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    private static final Duration POLLING = Duration.ofSeconds(100);

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage() {
        getManager();
        this.driver = getDriver();
        wait = new WebDriverWait(this.driver, TIMEOUT, POLLING);
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public void getManager() {
        DriverFactory.createWebDriverManager();
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public WebElement findElement(String selector) {
        return driver.findElement(By.cssSelector(selector));
    }

    public void clickElement(String selector) {
        findElement(selector).click();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getText(String selector) {
         return findElement(selector).getText();
    }

    public void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

}
