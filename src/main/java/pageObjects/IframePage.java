package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class IframePage extends BasePage {

    @FindBy(css = "iframe[name='iframe1']")
    private WebElement leftIFrame;
    @FindBy(css = "iframe[name='iframe2']")
    private WebElement rightIFrame;
    @FindBy(id = "inputFirstName3")
    private WebElement iFrameLeftFirstName;
    @FindBy(id = "inputSurname3")
    private WebElement iFrameLeftSurname;
    @FindBy(css = ".btn.btn-primary")
    private WebElement iFramesButton;
    @FindBy(id = "inputLogin")
    private WebElement iFrameRightLogin;
    @FindBy(id = "inputPassword")
    private WebElement iFrameRightPassword;
    @FindBy(id = "inlineFormCustomSelectPref")
    private WebElement iFrameRightContinents;
    @FindBy(css = ".form-check-input")
    private List<WebElement> iFrameRightYrsExperienceList;
    @FindBy(css = ".dropdown.nav-ite")
    private WebElement basicButtonTopDropDownMenu;

    public IframePage() {
    }

    public IframePage switchToLeftIFrame() {
        switchToIFrame(leftIFrame);
        return this;
    }

    public IframePage switchToRightIFrame() {
        switchToIFrame(rightIFrame);
        return this;
    }

    public IframePage setFirstName(String firstName) {
        iFrameLeftFirstName.sendKeys(firstName);
        return this;
    }

    public IframePage setSurname(String surname) {
        iFrameLeftSurname.sendKeys(surname);
        return this;
    }

    public IframePage signIn() {
        iFramesButton.click();
        return this;
    }

    public IframePage setLogin(String login) {
        iFrameRightLogin.sendKeys(login);
        return this;
    }

    public IframePage setPassword(String password) {
        iFrameRightPassword.sendKeys(password);
        return this;
    }

    public IframePage selectContinents(String continent) {
        new Select(iFrameRightContinents).selectByValue(continent);
        return this;
    }

    public IframePage selectYearsOfExp(int year) {
        iFrameRightYrsExperienceList.get(year + 1).click();
        return this;
    }

    public void defaultContent() {
        switchToDefaultContent();
    }

    public IframePage selectButtonFromTopMenu() {
        basicButtonTopDropDownMenu.click();
        return this;
    }

    public void navigateTo(String URL) {
        navigateToURL(URL);
    }

}
