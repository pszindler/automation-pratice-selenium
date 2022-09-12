package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectablePage extends BasePage {

    @FindBy(css = "ol#selectable > li:nth-of-type(1)")
    private WebElement element1;

    @FindBy(css = "ol#selectable > li:nth-of-type(3)")
    private WebElement element3;

    @FindBy(css = "ol#selectable > li:nth-of-type(4)")
    private WebElement element4;
    @FindBy(css = "p#feedback > span:nth-of-type(1)")
    private WebElement text;
    @FindBy(css = "span#select-result")
    private WebElement selectedItems;

    public void selectItem() {
        actions.keyDown(Keys.LEFT_CONTROL)
                .click(element1)
                .click(element3)
                .click(element4)
                .keyDown(Keys.LEFT_CONTROL)
                .build()
                .perform();

    }

    public String textResult() {
        return text.getText();
    }

    public String selectedItems() {
        return selectedItems.getText();
    }

    public void navigate() {
        navigateToURL("https://seleniumui.moderntester.pl/selectable.php");
    }

}
