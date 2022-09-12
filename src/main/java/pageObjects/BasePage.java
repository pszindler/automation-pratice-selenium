package pageObjects;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    BasePage() {
        getManager();
        this.driver = getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, TIMEOUT);
        actions = new Actions(driver);
    }

    private WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    private void getManager() {
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
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(firstWebElement)
                .click(secondWebElement)
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
    }

    protected void switchToIFrame(WebElement webElement) {
        driver.switchTo().frame(webElement);
    }

    protected void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

}
