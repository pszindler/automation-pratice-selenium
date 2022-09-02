package pageObjects;

public class AlertsPage extends BasePage {

    private final String alertsPageURL = "https://seleniumui.moderntester.pl/alerts.php";
    private final String buttonSimpleAlertCSS = "#simple-alert";
    private final String simpleAlertLabelCSS = "#simple-alert-label";
    private final String buttonPromptAlertCSS = "#prompt-alert";
    private final String promptAlertLabelCSS = "#prompt-label";
    private final String buttonDelayedAlertCSS = "#delayed-alert";
    private final String delayedAlertLabelCSS = "#delayed-alert-label";
    private final String buttonConfirmAlertCSS = "#confirm-alert";
    private final String confirmAlertLabelCSS = "#confirm-label";

    public String clickAndAcceptTheSimpleAlert() {
        navigateToURL(alertsPageURL);
        clickElement(buttonSimpleAlertCSS);
        dismissAlert();
        return getText(simpleAlertLabelCSS);
    }

    public String clickAndAcceptTheConfirmAlert(String text) {
        navigateToURL(alertsPageURL);
        clickElement(buttonPromptAlertCSS);
        sendKeysToAlert(text);
        acceptAlert();
        return getText(promptAlertLabelCSS);
    }

    public String clickConfirmAlertBox(Boolean isAccepted) {
        navigateToURL(alertsPageURL);
        clickElement(buttonConfirmAlertCSS);
        if (isAccepted) {
            acceptAlert();
        } else {
            dismissAlert();
        }
        return getText(confirmAlertLabelCSS);
    }

    public String clickDelayedAlert() {
        navigateToURL(alertsPageURL);
        clickElement(buttonDelayedAlertCSS);
        waitForAlert();
        acceptAlert();
        return getText(delayedAlertLabelCSS);
    }





}
