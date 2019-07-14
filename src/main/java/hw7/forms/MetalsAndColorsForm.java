package hw7.forms;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.XPath;
import com.epam.jdi.light.ui.html.complex.RadioButtons;
import hw7.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @XPath("//p[contains(.//label, '%s')]")
    private RadioButtons summary;

    @XPath("//p[@class='checkbox'][contains(., '%s')]//label")
    private UIElement elements;

    @JDropdown(root = "div[ui=dropdown]",
            list = "li",
            expand = ".caret")
    private Droplist colors;

    @JDropdown(root = "div[ui=combobox]",
            list = "li",
            expand = ".caret")
    private Droplist metals;

    @JDropdown(root = "div[ui=droplist]",
            list = "li",
            expand = ".caret")
    private Droplist vegetables;

    public void setSummary(MetalsAndColorsData mcd) {
        for (Integer item : mcd.getSummary()) {
            summary.select(String.valueOf(item));
        }
    }

    public void setElements(MetalsAndColorsData mcd) {
        for (String item : mcd.getElements()) {
            elements.select(item);
        }
    }

    public void setColors(MetalsAndColorsData mcd) {
        colors.select(mcd.getColor());
    }

    public void setMetals(MetalsAndColorsData mcd) {
        metals.select(mcd.getMetals());
    }

    public void setVegetables(MetalsAndColorsData mcd) {
        vegetables.select("Vegetables");

        for (String veg : mcd.getVegetables()) {
            vegetables.select(veg);
        }
    }

    public void setMetalsAndColorsForm(MetalsAndColorsData mcd) {
        setSummary(mcd);
        setElements(mcd);
        setColors(mcd);
        setMetals(mcd);
        setVegetables(mcd);
    }

}
