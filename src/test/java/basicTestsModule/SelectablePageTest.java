package basicTestsModule;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import pageObjects.SelectablePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SelectablePageTest extends BaseTest {

    SelectablePage selectablePage = new SelectablePage();

    @Test
    public void selectableTest() {
        selectablePage.navigate();
        selectablePage.selectItem();

        assertThat(selectablePage.textResult()).isEqualTo("You've selected:");
        assertThat(selectablePage.selectedItems()).isEqualTo("#1 #3 #4");

    }

}
