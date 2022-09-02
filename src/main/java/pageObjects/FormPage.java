package pageObjects;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class FormPage extends BasePage {

    Random random = new Random();

    private final String inputFirstNameCSS = "input#inputFirstName3";
    private final String inputLastNameNameCSS = "input#inputLastName3";
    private final String inputEmailCSS = "input#inputEmail3";
    private String gridRadioSexListCSS = ".form-check:nth-child(*) [name='gridRadiosSex']";
    private final String inputAgeCSS = "input#inputAge3";
    private String gridRadioExperienceListCSS = ".form-check:nth-child(*) [name='gridRadiosExperience']";
    private final String automationTesterCheckboxCSS = "input#gridCheckAutomationTester";
    private final String selectContinentsCSS = "#selectContinents";
    private String continentsListCSS = "#selectContinents option:nth-child(*)";
    private final String seleniumCommandsSwitchCommandsCSS = "[value='switch-commands']";
    private final String seleniumWaitCommandsCSS = "[value='wait-commands']";
    private final String buttonChooseFileCSS = "#chooseFile";
    private final String buttonTestFileToDownloadCSS = "[role='button']";
    private final String buttonSignInCSS = ".btn-primary";
    private final String filePath = "C:\\Development\\SzkolenieTesterskie\\SeleniumModernTester\\automation-pratice\\src\\main\\filesForUpload\\test-file-to-upload.xlsx";
    private final String validatorMessageCSS = "div#validator-message";
    private final String formURL = "https://seleniumui.moderntester.pl/form.php";
    private int getRandomValue(int from, int to) {
        return new Random().ints(from, to)
                .findFirst()
                .getAsInt();
    }

    private String randomSelector(String selector, int numberOfElement) {
        char newChar = String.valueOf(numberOfElement).charAt(0);
        return selector.replace('*', newChar);
    }

    public String FillTheForm(Faker faker) {
        navigateToURL(formURL);
        sendKeys(findElement(inputFirstNameCSS), faker.name().firstName());
        sendKeys(findElement(inputLastNameNameCSS), faker.name().lastName());
        sendKeys(findElement(inputEmailCSS), faker.internet().emailAddress());
        findElement(randomSelector(gridRadioSexListCSS, getRandomValue(1,3))).click();
        sendKeys(findElement(inputAgeCSS), "1000");
        findElement(randomSelector(gridRadioExperienceListCSS, getRandomValue(1,7))).click();
        findElement(automationTesterCheckboxCSS).click();
        findElement(selectContinentsCSS).click();
        findElement(randomSelector(continentsListCSS, getRandomValue(2,7))).click();
        selectMultipleElements(findElement(seleniumCommandsSwitchCommandsCSS), findElement(seleniumWaitCommandsCSS));
        sendKeys(findElement(buttonChooseFileCSS), filePath);
        findElement(buttonSignInCSS).click();
        return getText(validatorMessageCSS);
    }

}
