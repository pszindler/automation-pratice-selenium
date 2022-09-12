package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraggablePage extends BasePage {

    @FindBy(css = "#draggable")
    private WebElement square;

    JavascriptExecutor js = (JavascriptExecutor) driver;

    public int getWebElementLocationX() {
        return square.getLocation().x;
    }

    public int getWebElementLocationY() {
        return square.getLocation().y;
    }

    public int getWebElementHeight() {
        return square.getSize().getHeight();
    }

    public int getWebElementWidth() {
        return square.getSize().getWidth();
    }

    public long getWindowInnerWidth() {
        return (long) js.executeScript("return window.innerWidth;");
    }

    public long getWindowInnerHeight() {
        return (long) js.executeScript("return window.innerHeight;");
    }

    public void moveToTheRightTop() {
        int byXAxis = (int) (getWindowInnerWidth() - getWebElementLocationX() - getWebElementWidth());
        int byYAxis = -getWebElementLocationY();
        actions.dragAndDropBy(square, byXAxis, byYAxis).build().perform();
    }
    public void moveToTheRightBottom() {
        int byXAxis = (int) (getWindowInnerWidth() - getWebElementLocationX() - getWebElementWidth());
        int byYAxis = (int) (getWindowInnerHeight() - getWebElementLocationY() - getWebElementHeight());
        actions.dragAndDropBy(square, byXAxis, byYAxis).build().perform();
    }
    public void moveToTheCenter() {
        int byXAxis = (int) (getWindowInnerWidth() / 2 - getWebElementLocationX() - getWebElementWidth() / 2);
        int byYAxis = (int) (getWindowInnerHeight() / 2 - getWebElementLocationY() - getWebElementHeight() / 2);
        actions.dragAndDropBy(square, byXAxis, byYAxis).build().perform();
    }
    public void moveToTheBottomLeft() {
        int byXAxis = -getWebElementLocationX();
        int byYAxis = (int) (getWindowInnerHeight() - getWebElementLocationY() - getWebElementHeight());
        actions.dragAndDropBy(square, byXAxis, byYAxis).build().perform();
    }

    public void navigate() {
        navigateToURL("https://seleniumui.moderntester.pl/draggable.php");
    }

}
