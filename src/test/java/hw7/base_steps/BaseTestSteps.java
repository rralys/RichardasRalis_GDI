package hw7.base_steps;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.JDISite;
import hw7.entities.MetalsAndColorsData;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Arrays;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class BaseTestSteps {

    protected MetalsAndColorsData mcd = new MetalsAndColorsData(Arrays.asList(3, 8),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato"));

    @BeforeSuite
    public void setUp() {

        DriverData.CHROME_OPTIONS = () -> {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox", "start-maximized");
            return options;};

        initElements(JDISite.class);
    }

    @AfterSuite
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
