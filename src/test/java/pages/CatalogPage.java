package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasePage {



    //блок описания локатора для элемента
    private final By addBasketBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToCartLocator = By.className("shopping_cart_link");
    private final By headerTitleLocator = By.xpath("//span[contains(text(), 'Products')]");

    //Блок инициализаций страницы
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLocator;
    }

    //Блок атомарных методов
    public WebElement getAddBackpackToCart() {return driver.findElement(addBasketBackpackLocator);}
    public WebElement getGoToCart () {return driver.findElement(buttonGoToCartLocator);}

}
