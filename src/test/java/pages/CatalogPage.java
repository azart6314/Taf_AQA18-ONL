package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasePage {

    private final By addBasketBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToCartLocator = By.className("shopping_cart_link");
    private final By headerTitleLocator = By.xpath("//span[contains(text(), 'Products')]");

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLocator;
    }

    public WebElement getAddBackpackToCart() {return driver.findElement(addBasketBackpackLocator);}
    public WebElement getGoToCart () {return driver.findElement(buttonGoToCartLocator);}

}
