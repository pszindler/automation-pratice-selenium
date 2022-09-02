package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(5);

    protected WebDriver driver;
    private WebDriverWait wait;

    protected BasePage() {
        getManager();
        this.driver = getDriver();
        wait = new WebDriverWait(this.driver, TIMEOUT);
    }

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected void getManager() {
        DriverFactory.createWebDriverManager();
    }

    protected void navigateToURL(String url) {
        driver.get(url);
    }

    protected WebElement findElement(String selector) {
        return driver.findElement(By.cssSelector(selector));
    }

    protected void clickElement(String selector) {
        findElement(selector).click();
    }

    protected void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    protected String getText(String selector) {
         return findElement(selector).getText();
    }

    protected void sendKeysToAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    protected void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    protected void waitForAlert() {
        wait.ignoring(NoAlertPresentException.class)
                .until(ExpectedConditions.alertIsPresent());
    }
    protected void sendKeys(WebElement element, String path) {
        element.sendKeys(path);
    }

    protected void selectMultipleElements(WebElement firstWebElement, WebElement secondWebElement) {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(firstWebElement)
                .click(secondWebElement)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

}
