package tests;

import Factory.BrowserFactory;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_8 {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void hwTest() {
        driver.get(ReadProperties.getUrl());

        driver.findElement(By.cssSelector("#user-name")).sendKeys(ReadProperties.username());
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(ReadProperties.password());
        driver.findElement(By.xpath("//input[@type='submit' and @class='submit-button btn_action']")).click();
        driver.findElement(By.cssSelector("[name*='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//div/a[@class]")).click();
        Assert.assertEquals(driver.findElement(By.id("item_4_title_link")).getText(),
                "Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.cssSelector("[class$=item_price]")).getText(), "$29.99");


    }





}
