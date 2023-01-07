package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage {
    private WebDriver driver;


    //блок описания локатора для элемента
    private final By addBasketBackpackLocator = By.id("add-to-cart-sauce-labs-backpack");
    private final By buttonGoToCartLocator = By.className("shopping_cart_link");

    //Блок инициализаций страницы

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }


    //Блок атомарных методов
    public WebElement getAddBackpackToCart() {return driver.findElement(addBasketBackpackLocator);}
    public WebElement getGoToCart () {return driver.findElement(buttonGoToCartLocator);}

}
