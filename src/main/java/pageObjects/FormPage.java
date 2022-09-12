package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.text.Normalizer;
import java.util.List;
import java.util.Random;

public class FormPage extends BasePage {

    @FindBy(css = "input#inputFirstName3")
    private WebElement inputFirstNameCSS;
    @FindBy(css = "input#inputLastName3")
    private WebElement inputLastNameCSS;
    @FindBy(css = "input#inputEmail3")
    private WebElement inputEmailCSS;
    @FindBy(name = "gridRadiosSex")
    private List<WebElement> sexOptions;
    @FindBy(css = "input#inputAge3")
    private WebElement inputAgeCSS;
    @FindBy(name = "gridRadiosExperience")
    private List<WebElement> experienceOptions;
    @FindBy(css = "input#gridCheckAutomationTester")
    private WebElement automationTesterCheckboxCSS;
    @FindBy(css = "#selectContinents")
    private WebElement selectContinentsCSS;
    @FindBy(css = "[value='switch-commands']")
    private WebElement seleniumCommandsSwitchCommandsCSS;
    @FindBy(css = "[value='wait-commands']")
    private WebElement seleniumWaitCommandsCSS;
    @FindBy(css = "#chooseFile")
    private WebElement buttonChooseFileCSS;
    @FindBy(css = ".btn-primary")
    private WebElement buttonSignInCSS;
    @FindBy(css = "div#validator-message")
    private WebElement validatorMessageCSS;
    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumCommands;


    private int getRandomValue(int from, int to) {
        return new Random().ints(from, to)
                .findFirst()
                .getAsInt();
    }

    private String randomSelector(WebElement selector, int numberOfElement) {
        char newChar = String.valueOf(numberOfElement).charAt(0);
        String rtn = String.valueOf(selector);
        return rtn.replace('*', newChar);
    }

    public FormPage setFirstName(String firstName) {
        sendKeys(inputFirstNameCSS, firstName);
        return this;
    }

    public FormPage setLastName(String lastName) {
        sendKeys(inputLastNameCSS, lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        sendKeys(inputEmailCSS, email);
        return this;
    }

    public FormPage randomSetSex(int number) {
        sexOptions.get(number).click();
        return this;
    }

    public FormPage setAge(String age) {
        sendKeys(inputAgeCSS, age);
        return this;
    }

    public FormPage randomSetYearsOfExperience(int number) {
        experienceOptions.get(number).click();
        return this;
    }

    public FormPage setAutomationTesterBox() {
        automationTesterCheckboxCSS.click();
        return this;
    }

    public FormPage pickUpRandomContinent(String optionvalue) {
        new Select(selectContinentsCSS).selectByValue(optionvalue);
        return this;
    }

    public FormPage pickUpSeleniumCommands() {
        selectMultipleElements(seleniumCommandsSwitchCommandsCSS, seleniumCommandsSwitchCommandsCSS);
        return this;
    }

    public FormPage uploadFile(File file) {
        buttonChooseFileCSS.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage signIn() {
        buttonSignInCSS.click();
        return this;
    }

    public String getValidationMessage() {
        return validatorMessageCSS.getText();
    }

    public void navigateTo(String URL) {
        navigateToURL(URL);
    }

    public FormPage selectCommands() {
        new Select(seleniumCommands).selectByValue("switch-commands");
        new Select(seleniumCommands).selectByValue("wait-commands");
        return this;
    }

}
