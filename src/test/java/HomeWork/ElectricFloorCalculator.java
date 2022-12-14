package HomeWork;

import Factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElectricFloorCalculator {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
       // Thread.sleep(500);
        driver.quit();
    }

    @Test
    public void dataInputTest() throws InterruptedException {
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");
        driver.findElement(By.id("el_f_width")).sendKeys("3");
        driver.findElement(By.id("el_f_lenght")).sendKeys("4");
        WebElement selectRoomType = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectRoomType);
        selectRoom.selectByIndex(3);
        //selectRoom.selectByValue("3"); //просто для набивки руки что можно выбирать и так и так
        //selectRoom.deselectByVisibleText("Ванная");//просто для набивки руки что можно выбирать и так и так
        WebElement selectHeatingType = driver.findElement(By.id("heating_type"));
        Select heatingType = new Select(selectHeatingType);
        heatingType.selectByIndex(2);
        driver.findElement(By.id("el_f_losses")).sendKeys("10");
        driver.findElement(By.cssSelector("[name='button']")).click(); //это цсс селектор
        //ожид результат
        Assert.assertEquals(driver.findElement(By.id("floor_cable_power")).getAttribute("value"), "6");
        Assert.assertEquals(driver.findElement(By.id("spec_floor_cable_power")).getAttribute("value"), "0");
    }


}
