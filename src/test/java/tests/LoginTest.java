package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import io.qameta.allure.*;
import models.Project;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.projekt.AddProjectPage;
import steps.NavigationSteps;

public class LoginTest extends BaseTest {


//    @Test
    public void loginTest() {
        driver.get(ReadProperties.getUrl()); //не фак что надо

        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.getEmailInput().sendKeys(ReadProperties.username());
        LoginPage.getPassword().sendKeys(ReadProperties.password());
        LoginPage.getLogInButton().click();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

    @Test(description = "Description") //меняет само название в отчете
    @Issue("AQA18-12") //Тут указываем с каким багом связан
    @TmsLink("TC-001") //Тест кейс указываем с которым связан этот тест //Базову часть указываем в алюре тут вторая часть
    @Description ("Description1") //попадает в сам тест как более детолезированное описание в отчете
    @Link("https://onliner.by") //указываем просто ссылку которая отображается просто как ссылка
    @Link(name ="catalog", type = "mylink", url = "https://oliner.by")// реальная ссылка будет по нажаттию которой мы перейдем
    @Severity(SeverityLevel.BLOCKER) //тесты в отчете можно будет отфильтровать по важности
    public void loginSuccessfulTest() {

        Assert.assertTrue(
                userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password())
                        .isPageOpened());
    }


//        @Test
        public void loginIncorrectTest() {
            Assert.assertEquals(
                    userStep.loginIncorrect(ReadProperties.username(), "qwewqqqw")
                            .getErrorTextElement().getText(),
                    "Email/Login or Password is incorrect. Please try again."
            );
    }

    @Test
    public void addProjectTest() {
        Project project = new Project();
        project.setName("WP_01");
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        projectSteps.addProject(project);

        Assert.assertEquals(driver.findElement(By.className("page_title")).getText(),
                project.getName());
    }

    @Test
    public void radioButtonTest() {
        userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password());
        AddProjectPage page = new NavigationSteps(driver).navigateToAddProjectPage();
        page.getType().selectByIndex(1);
        page.getType().selectByValue("3");
        page.getType().selectByText("Use a single repository for all cases (recommended)");
    }

}
