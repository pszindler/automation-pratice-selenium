package basicTestsModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.DraggablePage;

public class DraggablePageTest extends BaseTest {

    DraggablePage draggablePage = new DraggablePage();

    @Test
    public void moveTheElement() {
        draggablePage.navigate();
        draggablePage.moveToTheRightTop();
        draggablePage.moveToTheRightBottom();
        draggablePage.moveToTheCenter();
        draggablePage.moveToTheBottomLeft();
    }
}
