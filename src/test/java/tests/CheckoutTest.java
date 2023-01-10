package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.CatalogPage;

public class CheckoutTest extends BaseTest {

 @Test
    public void checkoutTestSuccessful() {

        userStep.login(ReadProperties.username(),ReadProperties.password() );
        Assert.assertTrue(new CatalogPage(driver).isPageOpened());
        userStep.addToCartBackpack();
        Assert.assertTrue(new BasketPage(driver).isPageOpened());
        userStep.enteringUserInformation("Ruslan","Khadasevic", "123" );

    }

}
