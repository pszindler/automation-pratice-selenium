package basicTestsModule;

import base.BaseTest;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pageObjects.IframePage;


public class IFramePageTest extends BaseTest {

    IframePage iframePage = new IframePage();
    Faker faker = new Faker();
    private final String url = "https://seleniumui.moderntester.pl/iframes.php";

    @Test
    @DisplayName("Switch between iFrames")
    @Tag("iframe")
    @Tag("basic")
    void iFrameTest() {
        iframePage.navigateTo(url);
        iframePage.switchToLeftIFrame()
                .setFirstName(faker.name().firstName())
                .setSurname(faker.name().lastName());

        iframePage.defaultContent();

        iframePage.switchToRightIFrame()
                .setLogin(faker.name().username())
                .setPassword(faker.internet().password())
                .selectContinents("asia")
                .selectYearsOfExp(5);

        iframePage.defaultContent();
        iframePage.selectButtonFromTopMenu();




    }

}
