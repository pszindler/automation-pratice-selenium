package formModule;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObjects.FormPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FormPageTest extends BaseTest {
    FormPage formPage = new FormPage();
    Faker faker = new Faker();

    @ParameterizedTest
    @ValueSource(strings = {"Form send with success"})
    @DisplayName("Form test - positive case")
    @Tag("form")
    @Tag("basic")
    void fillTheFormWithSuccess(String label) {
        String result = formPage.FillTheForm(faker);
        assertThat(result).isEqualTo(label);
    }

}
