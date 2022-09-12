package basicTestsModule;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObjects.FormPage;

import java.io.File;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormPageTest extends BaseTest {
    FormPage formPage = new FormPage();
    Faker faker = new Faker();
    private final File file = new File("src/main/filesForUpload/test-file-to-upload.xlsx");
    private final String formURL = "https://seleniumui.moderntester.pl/form.php";
    @ParameterizedTest
    @ValueSource(strings = {"Form send with success"})
    @DisplayName("Form test - positive case")
    @Tag("form")
    @Tag("basic")
    void fillTheFormWithSuccess(String label) {
        formPage.navigateTo(formURL);
        formPage.setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                .randomSetSex(2)
                .setAge("29")
                .randomSetYearsOfExperience(5)
                .setAutomationTesterBox()
                .pickUpRandomContinent("asia")
                .selectCommands()
                .uploadFile(file)
                .signIn();

        assertThat(formPage.getValidationMessage()).isEqualTo(label);
    }

}
