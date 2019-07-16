package hw7.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.common.Text;
import hw7.entities.MetalsAndColorsData;
import hw7.forms.MetalsAndColorsForm;
import org.hamcrest.Matchers;

public class MetalsAndColorsPage extends WebPage {

    // TODO Same story about naming, JDISite:line_21 — Fixed.
    MetalsAndColorsForm metalsAndColorsForm;

    // TODO In most cases, submit button should be a part of a form. — Fixed.

    @XPath("//div[@class='info-panel-body info-panel-body-result']")
    private Text results;

    public void submitMetalsAndColorsForm(MetalsAndColorsData mcd) {
        metalsAndColorsForm.setMetalsAndColorsForm(mcd);
        metalsAndColorsForm.submitMetalsAndColorsForm();
    }

    public void verifyResultsSectionContainsSubmittedData(MetalsAndColorsData mcd) {
        results.shouldBe().text(Matchers.containsString(mcd.summary()));
        results.shouldBe().text(Matchers.containsString(mcd.elements()));
        results.shouldBe().text(Matchers.containsString(mcd.vegetables()));
        results.shouldBe().text(Matchers.containsString(mcd.getMetals()));
        results.shouldBe().text(Matchers.containsString(mcd.getColor()));
    }

}
