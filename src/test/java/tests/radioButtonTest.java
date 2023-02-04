package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.annotations.Test;
import pages.projekt.AddProjectPage;
import steps.NavigationSteps;

public class radioButtonTest extends BaseTest {

    @Test
    public void radioButtonTestTest() throws InterruptedException {
        userStep.loginSuccessful(ReadProperties.username(),ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }
}
