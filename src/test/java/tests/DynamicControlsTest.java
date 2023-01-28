package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkStringForEnableTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        WaitsService waitsService = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement checkBox = waitsService.waitForVisibilityBy(By.cssSelector("[type='checkbox']"));
        WebElement buttonRemove = waitsService.waitForVisibilityBy(By.cssSelector("[onclick='swapCheckbox()']"));
        buttonRemove.click();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's gone!");
        Assert.assertTrue(waitsService.waitForElementInvisible(checkBox));

        Assert.assertFalse(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());
        WebElement buttonEnable = waitsService.waitForVisibilityBy(By.xpath("//button[contains(text(), 'Enable')]"));
        buttonEnable.click();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("message")).getText(), "It's enabled!");

        Assert.assertTrue(driver.findElement(By.xpath("//input[@type='text']")).isEnabled());






    }




}
