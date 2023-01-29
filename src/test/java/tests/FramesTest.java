package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame("mce_0_ifr");


        driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).isDisplayed();

        driver.switchTo().parentFrame();

        driver.findElement(By.tagName("h3")).isDisplayed();
    }
}
