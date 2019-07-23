package hw7;

import hw7.base_steps.BaseTestSteps;
import hw7.entities.Users;
import org.testng.annotations.Test;

public class TestSteps extends BaseTestSteps {

    @Test
    public void testScenario() {
        JDISite.openHomePage();
        JDISite.homePage.shouldBeOpened();
        JDISite.homePage.loginUser(Users.PITER);
        JDISite.homePage.verifyUserName(Users.PITER.getName());
        JDISite.homePage.openMetalsAndColorsPage();
        JDISite.metalsAndColorsPage.submitMetalsAndColorsForm(mcd);
        JDISite.metalsAndColorsPage.verifyResultsSectionContainsSubmittedData(mcd);
    }
}
