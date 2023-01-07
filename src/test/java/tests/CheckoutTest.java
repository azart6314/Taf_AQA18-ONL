package tests;

import Factory.BrowserFactory;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new BrowserFactory().getDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkoutTest() throws InterruptedException {
        //бллок авторизаций и проверки
       driver.get(ReadProperties.getUrl());
       driver.findElement(By.id("user-name")).sendKeys(ReadProperties.username());
       driver.findElement(By.id("password")).sendKeys(ReadProperties.password());
       driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).isDisplayed());

        //блок добавления товара в корзину
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //блок перехода на страницу корзины и проверки
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'Your Cart')]")).isDisplayed());

        //переход на страницу оформления заказа и проверка
        driver.findElement(By.id("checkout")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Your Information')]")).isDisplayed());

        //воод валидных данных пользователя
        driver.findElement(By.id("first-name")).sendKeys("Ruslan");
        driver.findElement(By.id("last-name")).sendKeys("Khadasevic");
        driver.findElement(By.id("postal-code")).sendKeys("123");

        //Переход на страницу проверки данных и проверка
        driver.findElement(By.id("continue")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Overview')]")).isDisplayed());

        //Закончить оформление заказа и проверить
        driver.findElement(By.id("finish")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Complete')]")).isDisplayed());



    }

}
