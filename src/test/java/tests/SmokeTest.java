package tests;

import Factory.BrowserFactory;
import org.apache.commons.compress.compressors.lz77support.LZ77Compressor;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SmokeTest {
    private WebDriver driver; // что бы драйвер был доступен в рамках всего класса

    @BeforeMethod // используем анотацию
    public void setUp() { // создаем метод что бы каждый атомарным тестом создавался нвоый веб драйвер
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
    }


    @Test
    public void validateIKTCalculator() throws InterruptedException {
        driver.get("https://clinic-cvetkov.ru/company/kalkulyator-imt/"); //driver.get - позволяет переходить по опред ссылке

        WebElement heightInput = driver.findElement(By.name("height")); //driver.findElement -метод еотор вернет нам еонеретный экземпляр нейкого веб элемента  //findElement- вернет список таких элементов //крит олича есть
        WebElement weightInput = driver.findElement(By.name("weight")); //weight -название элемента смотрим в браузере, Input - тип элемента (название тэга в браузере)
        WebElement calcButton = driver.findElement(By.id("calc-mass-c"));//calc -название элемента смотрим в браузере, Button  - тип элемента (название тэга в браузере)

        heightInput.sendKeys("183");
        weightInput.sendKeys("58");
//        weightInput.sendKeys(Keys.CONTROL, Keys.ALT);//Keys. -после точки можно выбирать выриацию кравиш
        calcButton.click();

        Thread.sleep(2000);
        WebElement result = driver.findElement(By.id("imt-result")); // webElement, findElement- проверка результата (ожид результат)
        Assert.assertEquals(result.getText(), //getText - метод для проверки между откр и закр тэгом
                "17.3 - Недостаточная (дефицит) масса тела"); //Assert.assertEquals -
    }

    @Test
    public void validateSKFTest() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement selectWebElement = driver.findElement(By.id("oSex")); // берем именно веб элемент select и выбираем id
        Select selectSex = new Select(selectWebElement); //проводим инициализацию. Для проверки дроп даунов
        selectSex.selectByIndex(1);// можно выбрать один из 3  способов
//        Thread.sleep(2000);// что бы увидеть результат
//        selectSex.selectByValue("0"); //строка не число. что бы сенить
//        Thread.sleep(2000);
//        selectSex.selectByVisibleText("женский"); //текст ктороый отображается. значения опшенс элементов
//        Thread.sleep(2000);

        driver.findElement(By.id("oCr")).sendKeys("80");
        driver.findElement(By.id("oAge")).sendKeys("38");
        driver.findElement(By.id("oWeight")).sendKeys("55");
        driver.findElement(By.id("oHeight")).sendKeys("163");
        driver.findElement(By.cssSelector("[type='button']")).click();

                   //Далее ожилаемы результат проверка
        Assert.assertEquals(driver.findElement(By.id("txtMDRD")).getText(),
                "MDRD: 74 (мл/мин/1,73кв.м)");
        Assert.assertEquals(driver.findElement(By.id("txtBSA")).getText(),
                "Поверхность тела:1.58 (кв.м)");
        Assert.assertEquals(driver.findElement(By.id("txtCG")).getText(),
                "MDRD: 74 (мл/мин/1,73кв.м)");





    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    } // создаем метот что бы убить процесс после выполнения брайзера
}
