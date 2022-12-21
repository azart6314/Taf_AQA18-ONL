package tests;

import Factory.BrowserFactory;
import baseEntities.BaseTest;
import com.fasterxml.jackson.databind.ser.Serializers;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import steps.UserStep;

public class LoginTest extends BaseTest {


    @Test
    public void loginTest() {
        driver.get(ReadProperties.getUrl()); //не фак что надо

        LoginPage LoginPage = new LoginPage(driver);
        LoginPage.getEmailInput().sendKeys(ReadProperties.username());
        LoginPage.getPassword().sendKeys(ReadProperties.password());
        LoginPage.getLogInButton().click();

        Assert.assertTrue(new DashboardPage(driver).isPageOpened());
    }

     @Test
    public void loginSuccessfulTest() {

        Assert.assertTrue(userStep.loginSuccessful(ReadProperties.username(), ReadProperties.password()) .isPageOpened());
    }


        @Test
        public void loginIncorrectTest() {
            Assert.assertEquals(
                    userStep.loginIncorrect(ReadProperties.username(), "qwewqqqw")
                            .getErrorTextElement().getText(),
                    "Email/Login or Password is incorrect. Please try again."
            );
    }


}
