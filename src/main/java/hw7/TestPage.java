package hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw7.pages.HomePage;
import hw7.pages.MetalsAndColorsPage;

@JSite("https://epam.github.io/JDI/")
public class TestPage {

    @Url("index.html")
    @Title("Home Page")
    public static HomePage homePage;

    @Url("metals-color.html")
    @Title("Metals and Colors")
    public static MetalsAndColorsPage mcp;

    public static void openHomePage() {
        homePage.open();
        homePage.getUserName();
    }
}
