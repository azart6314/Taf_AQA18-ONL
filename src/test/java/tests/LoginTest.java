package tests;

import Factory.BrowserFactory;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.id("name")).sendKeys(ReadProperties.username());
        driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
        driver.findElement(By.id("button_primary")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'All Projects')]")).isDisplayed());
    }
}
