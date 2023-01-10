package Steps; // тут ничего не должно проверяться не каких асертов

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.BasketPage;
import pages.CatalogPage;
import pages.LoginPage;

public class UserStep extends BaseStep {
    private LoginPage loginPage;
    private CatalogPage catalogPage;
    private BasketPage basketPage;

    public UserStep(WebDriver driver) {
        super(driver);

        loginPage = new LoginPage(driver);
        catalogPage = new CatalogPage (driver);
        basketPage = new BasketPage(driver);
    }

    public void login (String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPassword().sendKeys(psw);
        loginPage.getLoginButton().click();
    }

    public void addToCartBackpack ( ) {
        catalogPage.getAddBackpackToCart().click();
        catalogPage.getGoToCart().click();
    }

    public void enteringUserInformation(String firstName, String lastName, String postalCode) {
        basketPage.getGoToCheckout().click();
        basketPage.getFirstName().sendKeys(firstName);
        basketPage.getLastName().sendKeys(lastName);
        basketPage.getPostalCode().sendKeys(postalCode);
        basketPage.getButtonContinueOrdering().click();
        basketPage.getButtonFinishOrder().click();
    }

}
