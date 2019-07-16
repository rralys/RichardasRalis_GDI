package hw7.base_steps;

import com.epam.jdi.light.driver.get.DriverData;
import hw7.TestPage;
import hw7.entities.MetalsAndColorsData;
import hw7.entities.Users;
import org.hamcrest.Matchers;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;

public class BaseTestSteps {

    protected MetalsAndColorsData mcd = new MetalsAndColorsData(Arrays.asList(3, 8),
            Arrays.asList("Water", "Fire"),
            "Red",
            "Selen",
            Arrays.asList("Cucumber", "Tomato"));

    @BeforeMethod
    public void startUp() {
        // TODO 1. This code should not be here, we should apply this settings to the whole suite at once
        // TODO 2. In this case it is not the best idea to make lambda exp with closure, read this article briefly:
        // https://habr.com/ru/company/piter/blog/281026/
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "start-maximized");
        DriverData.CHROME_OPTIONS = () -> {return options;};

        initElements(TestPage.class);
        // !TODO 1

        TestPage.openHomePage();
        TestPage.homePage.shouldBeOpened();
        TestPage.homePage.loginUser(Users.PITER);
        TestPage.homePage.getUserName().shouldBe().text(Matchers.equalTo(Users.PITER.getName()));
        TestPage.homePage.openMetalsAndColorsPage();
    }

    @AfterMethod
    public void tearDown() {
        killAllSeleniumDrivers();
    }
}
