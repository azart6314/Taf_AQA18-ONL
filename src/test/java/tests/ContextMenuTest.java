package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {


    @Test
    public void openContextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
        WebElement contextMenuSquare = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions
                .contextClick(waitsService.waitForVisibilityBy(By.id("hot-spot")))
                .build()
                .perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"You selected a context menu");
        alert.accept();
    }



}
