package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.projekt.AddTestCasePage;
import steps.NavigationSteps;

public class DropDownMenuTest extends BaseTest {

    @Test
    public void DropDownMenuTest() {
            userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
            AddTestCasePage page = new NavigationSteps(driver).navigateToAddTestCasePage();

            page.getDropDown();


                //.select(By.id("template_id_chzn_o_1"));

        }
}
