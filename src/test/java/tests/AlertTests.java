package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTests extends BaseTest {

    @Test
    public void infoAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS Alert"); //текст который появляется в аллерте

        alert.accept(); //команда окей, принять
    }

    @Test
    public void confirmAlertTest() {  //отличается тем что есть две кнопки ок и не ок
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert(); // нажимаем и переключаемся на аллерт

        Assert.assertEquals(alert.getText(), "I am a JS Confirm");

        alert.accept(); //соглашаемся

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok"); //проверка

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click(); //нажатие

        alert = driver.switchTo().alert(); // переключение появление новго

        Assert.assertEquals(alert.getText(), "I am a JS Confirm"); //нажатие на кнопку нет касел

        alert.dismiss();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
    }

    @Test
    public void promptAlertTest() {   //отличается тем что появляется нейкое поле текста для ввода если требуется
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(), "I am a JS prompt");

        alert.sendKeys("sdfsdf");
        alert.accept();

        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: sdfsdf");
    }


}
