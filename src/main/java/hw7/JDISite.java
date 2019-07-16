package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.HomePage;
import hw7.pages.MetalsAndColorsPage;

// TODO Basically, this is not a Page, take a look on annotation. — Updated the class name.
@JSite("https://epam.github.io/JDI/")
public class JDISite {

    @Url("index.html")
    @Title("Home Page")
    public static HomePage homePage;

    @Url("metals-color.html")
    @Title("Metals and Colors")
    // TODO This is not the best idea to use abbreviation like this.
    // Besides, you have full name of field on line 15, so you should use only one naming approach. — Fixed.
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void openHomePage() {
        homePage.open();
        // TODO Take a look on IDEA warning. What is the reason of this call ? — Removed the unnecessary call.
    }
}
