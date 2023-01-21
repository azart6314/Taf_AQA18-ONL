package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FrameTests extends BaseTest {

    @Test
    public void frameTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");

        driver.findElement(By.tagName("h3")).isDisplayed();

        WebElement frameElement = driver.findElement(By.tagName("iframe"));
        //driver.switchTo().frame(frameElement); // через элемент
        //driver.switchTo().frame(0);
        driver.switchTo().frame("mce_0_ifr"); //тэг с атрибутом iframe в девтулсе. Может быть не уникальным если есть несколько. Тут по id

        driver.findElement(By.xpath("//p[. = 'Your content goes here.']")).isDisplayed();

        //driver.switchTo().parentFrame(); // Переключиться в родительский документ (вернуться на один уровень выше )
        driver.switchTo().defaultContent(); // Переключает в первоначальный документ

        driver.findElement(By.tagName("h3")).isDisplayed();
    }



}
