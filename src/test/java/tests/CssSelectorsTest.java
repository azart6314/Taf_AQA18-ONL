package tests;

import Factory.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CssSelectorsTest {
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
    public void cssLocatorTest() {
        driver.get("D:\\Teach_me_skills\\avtomat\\CW1_QA_18_Onl\\Taf_AQA18-ONL\\src\\test\\resources\\index.html");

        //Поиск по id
        Assert.assertTrue(driver.findElement(By.cssSelector("#my-Address")).isDisplayed()); //это написание эдно и тоже как и By.id("my-Address")
        Assert.assertTrue(driver.findElement(By.id("my-Address")).isDisplayed()); //два одинаковых варианта разное написание

        //Поиск по class name. Если хотим найти только один из наме используем в дев туле точку
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("newsletter")).isDisplayed());

        //Поск по нескольким значением в атрибудет class (значений может быть сколько угодно)
        Assert.assertTrue(driver.findElement(By.cssSelector(".newsletter.noSel")).isDisplayed());

        //Поск по tage name
        Assert.assertTrue(driver.findElement(By.cssSelector("h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("h1")).isDisplayed());

        //Поск по tage name и значению class name
        Assert.assertTrue(driver.findElement(By.cssSelector("div.intro")).isDisplayed());

        //Поск элемента по clsassname c с учетом иерарфий //- #Lastname .markup  еще - .intro .markup
        Assert.assertEquals(6, driver.findElements(By.cssSelector("#Lastname .markup")).size(), 2); //size потмоу что много элементов на странице таких

        //Поск всех элементов с tagname h1 или p //h1, p
        Assert.assertEquals(6, driver.findElements(By.cssSelector("h1, p")).size(), 8);

        // Поиск всех элементов с тэгом p у которых непосредственный родитель с тэгом div //div > p
        Assert.assertEquals(6, driver.findElements(By.cssSelector("div > p")).size());

        // Поиск всех элементов с тэгом p которые идут сразу за элементом с тэго ul
        Assert.assertEquals(1, driver.findElements(By.cssSelector("ul + p")).size());

        // Поиск всех элементов у которых присутствует атрибут Lang
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p[lang]")).size());

        // Поиск всех элементов у которых присутствует аттрибут style с конкретным значением
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[style='overflow: auto;']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением заканчивающимся на какое-то value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id$='ess']")).size());

        // Поиск всех элементов у которых присутствует аттрибут id со значением начинающимся на какое-то value
        Assert.assertEquals(2, driver.findElements(By.cssSelector("[id^=L]")).size());

        // Поиск всех элементов у которых присутствует аттрибут id с начинающимся словом value
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[id|=my]")).size());

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим слово целиком
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title~=beautiful]")).size());
        /////

        // Поиск всех элементов у которых присутствует аттрибут title со значением содержащим подстроку
        Assert.assertEquals(1, driver.findElements(By.cssSelector("[title*='o beautiful']")).size());

                                    //Поиск свойст гейких элементов ( гачинается с :)
        // Поиск всех disabled элементов
        Assert.assertEquals(1, driver.findElements(By.cssSelector(":disabled")).size());

        // Поиск всех enabled элементов
        Assert.assertEquals(8, driver.findElements(By.cssSelector(":enabled")).size());

        // Поиск всех выборанных элементов
        Assert.assertEquals(2, driver.findElements(By.cssSelector(":checked")).size());

        // Поиск всех элементов c пустым телом
        Assert.assertEquals(16, driver.findElements(By.cssSelector(":empty")).size());

                        //Вещи работающие с css

        // Поиск элемента с тэгом p и которым является первым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:first-child")).size());

        // Поиск элемента с тэгом p и которым является последним дочерним элементом
        Assert.assertEquals(2, driver.findElements(By.cssSelector("p:last-child")).size());

        // Поиск элемента с тэгом p и которым является n-ым дочерним элементом
        Assert.assertEquals(1, driver.findElements(By.cssSelector("p:nth-child(2)")).size());
    //////



    }


}
