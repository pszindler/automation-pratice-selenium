package basicTestsModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.DragAndDropPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DragAndDropPageTest extends BaseTest {

    @Test
    public void dragAndDropTest() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();
        dragAndDropPage.navigate("https://seleniumui.moderntester.pl/droppable.php");
        dragAndDropPage.dragAndDrop();

        assertThat(dragAndDropPage.validateMessage()).isEqualTo("Dropped!");
    }
}
