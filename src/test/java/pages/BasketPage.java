package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasketPage extends BasePage {

    //блок описания локатора для элемента
    private final By goToCheckoutPageLocator = By.id("checkout");
    private final By firstNameLocator = By.id("first-name");
    private final By lastNameLocator = By.id("last-name");
    private final By postalCodeLocator = By.id("postal-code");
    private final By buttonContinueOrderingLocator = By.id("continue");
    private final By buttonFinishOrderLocator = By.id("finish");
    private final By headerTitleBasketLocator = By.xpath("//span[contains(text(), 'Your Cart')]");


    //Блок инициализаций страницы
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleBasketLocator;
    }


    //Блок атомарных методов
    public WebElement getGoToCheckout() {return driver.findElement(goToCheckoutPageLocator);}
    public WebElement getFirstName() {return driver.findElement(firstNameLocator);}
    public WebElement getLastName() {return driver.findElement(lastNameLocator);}
    public WebElement getPostalCode() {return driver.findElement(postalCodeLocator);}
    public WebElement getButtonContinueOrdering() {return driver.findElement(buttonContinueOrderingLocator);}
    public WebElement getButtonFinishOrder() {return driver.findElement(buttonFinishOrderLocator);}


}
