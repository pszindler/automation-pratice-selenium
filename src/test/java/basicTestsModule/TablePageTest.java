package basicTestsModule;

import base.BaseTest;
import driver.DriverFactory;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.TablePage;

public class TablePageTest extends BaseTest {
    TablePage tablePage = new TablePage();
    WebDriver driver = DriverFactory.getDriver();

    @Test
    public void printPeak() {
        driver.get("https://seleniumui.moderntester.pl/table.php");
        tablePage.printOutTheData();

    }
}
