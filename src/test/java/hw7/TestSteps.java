package hw7;

import hw7.base_steps.BaseTestSteps;
import org.testng.annotations.Test;

public class TestSteps extends BaseTestSteps {

    @Test
    public void testScenario() {
        TestPage.homePage.openMetalsAndColorsPage();
        TestPage.mcp.submitMetalsAndColorsForm(mcd);
        TestPage.mcp.verifyResultsSectionContainsSubmittedData(mcd);
    }
}
