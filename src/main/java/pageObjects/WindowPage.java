package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WindowPage extends BasePage {
    @FindBy(css = "button#newBrowserWindow")
    private WebElement newBrowserWindowButton;
    @FindBy(css = "button#newMessageWindow")
    private WebElement newMessageWindowButton;
    @FindBy(css = "button#newBrowserTab")
    private WebElement newBrowserTabButton;
    @FindBy(css = "body")
    private WebElement bodyText;

    public WindowPage newBrowserWindow() {
        newBrowserWindowButton.click();
        return this;
    }

    public WindowPage newMessageWindow() {
        newMessageWindowButton.click();
        return this;
    }

    public WindowPage newBrowserTab() {
        newBrowserTabButton.click();
        return this;
    }

    public String getBodyText() {
       return bodyText.getText();
    }

    public void closeWindow() {
        driver.close();
    }

    public void backToOriginalWindow(String originalWindow) {
        driver.switchTo().window(originalWindow);
    }

    public String getOriginalWindow() {
        return driver.getWindowHandle();
    }

    public void switchToNewWindow() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!getOriginalWindow().contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void getUrl(String url) {
        navigateToURL(url);
    }

}
