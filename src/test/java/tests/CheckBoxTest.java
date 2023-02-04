package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.projekt.AddProjectPage;
import steps.NavigationSteps;

public class CheckBoxTest extends BaseTest {

    @Test
    public void CheckBoxTest () {
        userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getCheckBox().select();
        page.getCheckBox().unselect();

    }
}
