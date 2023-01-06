package tests;

import Factory.BrowserFactory;
import baseEntities.BaseTestSWAG;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPageSWAG;
import pages.LoginPageSWAG;

public class LoginTestSWAG extends BaseTestSWAG {

    @Test
    public void loginTest(){
        //изночально тут было но перенесили в baseTestSWAG в метод @Before
        //driver.get(ReadProperties.getUrl()); //метот которым мы берес ссылку на сайт куда надо перейти из ReadProperties



        LoginPageSWAG LoginPageSWAG =new LoginPageSWAG(driver);
        LoginPageSWAG.getNameInput().sendKeys(ReadProperties.username());
        LoginPageSWAG.getPasswordInputLocator().sendKeys(ReadProperties.password());
        LoginPageSWAG.getLoginButtonLocator().click();


        //изночально было так
        // driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        //driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
        //driver.findElement(By.name("login-button")).click();

        Assert.assertTrue(new DashboardPageSWAG(driver).isPageOpened()); //осуществляет проверку нахождения элемента на странице
    }



}
