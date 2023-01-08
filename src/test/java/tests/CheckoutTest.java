package tests;

import Factory.BrowserFactory;
import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CatalogPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTest() {


       LoginPage loginPage = new LoginPage(driver); // надо будет сделать потом на каждую страницу

        //страница авторизаций
        //бллок авторизаций и проверкиloginPage.getEmailInput().sendKeys(ReadProperties.username());
       loginPage.getPassword().sendKeys(ReadProperties.password());
       loginPage.getLoginButton().click();

        Assert.assertTrue(new CatalogPage(driver).ipPageOpened());

        //страница каталога
        CatalogPage catalogPage = new CatalogPage(driver);
        //блок добавления товара в корзину, перехода на страницу корзины и проверки
        catalogPage.getAddBackpackToCart().click();
        catalogPage.getGoToCart().click();

        Assert.assertTrue(new BasketPage(driver).ipPageOpened());

        //страница корзины
        BasketPage basketPage = new BasketPage(driver);
        //переход на страницу оформления заказа и проверка
        basketPage.getGoToCheckout().click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Your Information')]")).isDisplayed());

        //воод валидных данных пользователя, Переход на страницу проверки данных и проверка
        basketPage.getFirstName().sendKeys("Ruslan");
        basketPage.getLastName().sendKeys("Khadasevic");
        basketPage.getPostalCode().sendKeys("123");
        basketPage.getButtonContinueOrdering().click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Overview')]")).isDisplayed());

        //Закончить оформление заказа и проверить
        basketPage.getButtonFinishOrder().click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Checkout: Complete')]")).isDisplayed());



    }

}
