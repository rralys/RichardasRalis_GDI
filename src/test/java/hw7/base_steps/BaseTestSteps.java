package hw7.base_steps;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.JDISite;
import hw7.entities.MetalsAndColorsData;
import hw7.entities.Users;
import org.hamcrest.Matchers;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class BaseTestSteps {

    protected MetalsAndColorsData mcd = new MetalsAndColorsData(Arrays.asList(3, 8),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato"));

    @BeforeClass
    public void setUp() {

        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "start-maximized");
            return options;};

        initElements(JDISite.class);
    }

    @AfterMethod
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
