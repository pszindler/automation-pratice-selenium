package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class TablePage extends BasePage {

    @FindBy(css = "tbody tr")
    private List<WebElement> allPeaks;

    @FindBy(css = "thead tr")
    private List<WebElement> header;

    public List<RowPage> getAllPeaks() {
        List<RowPage> allPeaksPo = new ArrayList<>();

        for (WebElement peak : allPeaks) {
            allPeaksPo.add(new RowPage(peak));
        }
        return allPeaksPo;
    }

    public void printOutTheData() {
        for (RowPage peakData : getAllPeaks()) {
            if (peakData.getState().contains("Switzerland") && peakData.getHeight() > 4000) {
                System.out.println(peakData);
            }
        }
    }

}
