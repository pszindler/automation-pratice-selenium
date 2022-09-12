package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResizablePage extends BasePage {

    @FindBy(css = "#resizable")
    private WebElement resizable;

    public void resizeSquare() {
        int width = resizable.getSize().width;
        int height = resizable.getSize().height;
        actions.moveToElement(resizable, (width / 2) - 1 , -(height / 2) + 1 )
                .clickAndHold().moveByOffset(300,-1).release().build().perform();
    }

    public void resizeSquareDown() {
        int width = resizable.getSize().width;
        int height = resizable.getSize().height;
        actions.moveToElement(resizable, 1 , (height / 2) +1)
                .clickAndHold().moveByOffset(-1,-100).release().build().perform();
    }

    public void resize() {
        actions.clickAndHold(resizable).moveByOffset(100 + 18, 100).release().build().perform();
    }

    public void navigate() {
        navigateToURL("https://seleniumui.moderntester.pl/resizable.php");
    }
}
