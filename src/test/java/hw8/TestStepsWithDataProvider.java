package hw8;

import hw7.JDISite;
import hw7.base_steps.BaseTestSteps;
import hw7.entities.MetalsAndColorsData;
import hw7.entities.Users;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class TestStepsWithDataProvider extends BaseTestSteps {
    @Test(dataProvider = "testDataProvider", dataProviderClass = TestDataProvider.class)
    public void testScenarioWithDataProvider(MetalsAndColorsData metalsAndColorsData) {
        JDISite.openHomePage();
        JDISite.homePage.shouldBeOpened();
        JDISite.homePage.loginUser(Users.PITER);
        // TODO This action should be encapsulate in PO method and parametrised by Users.PITER itself.
        JDISite.homePage.getUserName().shouldBe().text(Matchers.equalTo(Users.PITER.getName()));
        // !TODO
        // TODO What is the reason of two call of this method ?
        JDISite.homePage.openMetalsAndColorsPage();
        JDISite.homePage.openMetalsAndColorsPage();
        // !TODO
        JDISite.metalsAndColorsPage.submitMetalsAndColorsForm(metalsAndColorsData);
        JDISite.metalsAndColorsPage.verifyResultsSectionContainsSubmittedData(metalsAndColorsData);
        JDISite.homePage.logout();
    }

}
