package pageObjects;

public class BasicPage extends BasePage {

    private final String filmwebURL = "https://www.filmweb.pl";

    public void checkTitleSite() {
       navigateToURL(filmwebURL);
    }

    public void fillFromAndCheckSuccess() {

    }
}
