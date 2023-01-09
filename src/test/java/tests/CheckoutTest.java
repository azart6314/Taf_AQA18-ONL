package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CatalogPage;

public class CheckoutTest extends BaseTest {

//    @Test
//    public void checkoutTest() {
//
//
//       LoginPage loginPage = new LoginPage(driver); // надо будет сделать потом на каждую страницу
//
//        //страница авторизаций
//        //бллок авторизаций и проверки
//       loginPage.getEmailInput().sendKeys(ReadProperties.username());
//       loginPage.getPassword().sendKeys(ReadProperties.password());
//       loginPage.getLoginButton().click();
//
//        Assert.assertTrue(new CatalogPage(driver).isPageOpened());
//
//        //страница каталога
//        CatalogPage catalogPage = new CatalogPage(driver);
//        //блок добавления товара в корзину, перехода на страницу корзины и проверки
//        catalogPage.getAddBackpackToCart().click();
//        catalogPage.getGoToCart().click();
//
//        Assert.assertTrue(new BasketPage(driver).isPageOpened());
//
//        //страница корзины
//        BasketPage basketPage = new BasketPage(driver);
//        //переход на страницу оформления заказа и проверка
//        basketPage.getGoToCheckout().click();
//
//
//        //воод валидных данных пользователя, Переход на страницу проверки данных и проверка
//        basketPage.getFirstName().sendKeys("Ruslan");
//        basketPage.getLastName().sendKeys("Khadasevic");
//        basketPage.getPostalCode().sendKeys("123");
//        basketPage.getButtonContinueOrdering().click();
//
//
//        //Закончить оформление заказа и проверить
//        basketPage.getButtonFinishOrder().click();

 @Test
    public void checkoutTestSuccessful() {

        userStep.login(ReadProperties.username(),ReadProperties.password() );
        Assert.assertTrue(new CatalogPage(driver).isPageOpened());

        //страница каталога

        userStep.addToCartBackpack();
        Assert.assertTrue(new BasketPage(driver).isPageOpened());

        //страница корзины

        //переход на страницу оформления заказа и проверка
        userStep.enteringUserInformation("Ruslan","Khadasevic", "123" );

    }

}
