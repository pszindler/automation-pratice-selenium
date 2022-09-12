package basicTestsModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.TablePage;
import pageObjects.WindowPage;

public class WindowPageTest extends BaseTest {
    WindowPage windowPage = new WindowPage();
    TablePage tablePage = new TablePage();

    @Test
    public void windowsChange() {
        windowPage.getUrl("https://seleniumui.moderntester.pl/windows-tabs.php");
        String baseWindow = windowPage.getOriginalWindow();
        windowPage.newBrowserWindow();
        windowPage.switchToNewWindow();
        tablePage.printOutTheData();
        windowPage.closeWindow();
        windowPage.backToOriginalWindow(baseWindow);
        windowPage.newMessageWindow();
        windowPage.switchToNewWindow();
        System.out.println(windowPage.getBodyText());
        windowPage.closeWindow();
        windowPage.backToOriginalWindow(baseWindow);
        windowPage.newBrowserTab();
        windowPage.switchToNewWindow();
        tablePage.printOutTheData();
        windowPage.closeWindow();




    }
}
