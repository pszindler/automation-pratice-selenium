package basicTestsModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.ResizablePage;

public class ResizablePageTest extends BaseTest {

    ResizablePage resizablePage = new ResizablePage();

    @Test
    public void resizableSquare() {
        resizablePage.navigate();
        resizablePage.resizeSquare();
        resizablePage.resizeSquareDown();

        System.out.println("TEST");
    }
}
