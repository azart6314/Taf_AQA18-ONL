package tests;

import Factory.BrowserFactory;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestSWAG {
    private WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void loginTest(){
        driver.get(ReadProperties.getUrl()); //метот которым мы берес ссылку на сайт куда надо перейти из ReadProperties

        driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.name("login-button")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector("span.title")).isDisplayed(), "Products"); //24 мин видоса
    }


}
