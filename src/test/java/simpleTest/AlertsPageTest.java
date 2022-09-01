package simpleTest;

import base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pageObjects.AlertsPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class simpleTesty extends BaseTest {
    AlertsPage alertsPage = new AlertsPage();

    @ParameterizedTest
    @ValueSource(strings = {"OK button pressed"})
    @DisplayName("Check simple alert pop up")
    @Tag("alert")
    @Tag("basic")
    void checkSimpleAlertPopUp(String label) {
        String result = alertsPage.clickAndAcceptTheSimpleAlert();
        assertThat(result).isEqualTo(label);
    }

    @ParameterizedTest
    @ValueSource(strings = {"OK button pressed"})
    @DisplayName("Check simple alert pop up")
    @Tag("alert")
    @Tag("basic")
    void checkConfirmAlertBox(String label) {
        String result = alertsPage.clickAndAcceptTheSimpleAlert();
        assertThat(result).isEqualTo(label);
    }

}
