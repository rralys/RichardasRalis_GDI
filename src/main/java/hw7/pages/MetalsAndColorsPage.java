package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Text;
import hw7.entities.MetalsAndColorsData;
import hw7.forms.MetalsAndColorsForm;
import org.hamcrest.Matchers;

import java.awt.*;

public class MetalsAndColorsPage extends WebPage {

    MetalsAndColorsForm mcf;

    @XPath("//button[@id='submit-button']")
    private Button submit;

    @XPath("//div[@class='info-panel-body info-panel-body-result']")
    private Text results;

    public void submitMetalsAndColorsForm(MetalsAndColorsData mcd) {
        mcf.setMetalsAndColorsForm(mcd);
        submit.click();
    }

    public void verifyResultsSectionContainsSubmittedData(MetalsAndColorsData mcd) {
        results.shouldBe().text(Matchers.containsString(mcd.summary()));
        results.shouldBe().text(Matchers.containsString(mcd.elements()));
        results.shouldBe().text(Matchers.containsString(mcd.vegetables()));
        results.shouldBe().text(Matchers.containsString(mcd.getMetals()));
        results.shouldBe().text(Matchers.containsString(mcd.getColor()));
    }

}
