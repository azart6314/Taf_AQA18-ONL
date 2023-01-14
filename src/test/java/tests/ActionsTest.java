package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");

        List<WebElement> targetElements = waitsService.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));

        Actions actions = new Actions(driver);
        actions // в самом экшене проверок нет
                .moveToElement(targetElements.get(0), 10, 10) //добавили смещение на 10 пикселей влево и вниз
                .click(waitsService.waitForExists(By.cssSelector("[href='/users/1']"))) //проверка что именно туда навели и кликнули
                .build()
                .perform(); //выполнить . только в этот момент происходят действия

        Assert.assertTrue(waitsService.waitForElementInvisible(targetElements.get(0))); //дождались что элемент пропал
    }

    @Test // более не верный тест ( ниже правильнее)
    public void fileUploadTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = "src" + File.separator + "test/resources/download.jpeg";
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Thread.sleep(5000);
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "download.jpeg");
    }

    @Test
    public void fileUploadTest() throws InterruptedException {  //загрузка файла. Ищес элемент с отрибутов файл
        driver.get("http://the-internet.herokuapp.com/upload");

        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@type='file']"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath(); //Путь к файлу. getPath -возвращает обсалютный путь к этому файлу в системе (в независимости где будет запускаться код )
        System.out.println(pathToFile);

        fileUploadElement.sendKeys(pathToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();

        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),
                "download.jpeg");
    }

}
