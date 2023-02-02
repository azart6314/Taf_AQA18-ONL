package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов Блок описания локаторов для эментов (обычно приветные финальные значения для by) ( в этот блок вносим только те элементы которые относятся только к этой странице и ничего больше )
//    private final By emailInputLocator = By.id("name");
//    private final By passwordInputLocator = By.id("password");
//    private final By logInButtonLocator = By.id("button_primary");
//    private final By errorTextLocator = By.className("error-text");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    @Override
//    protected By getPageIdentifier() {  //обычно выдирается самый медленный для загрузки метод или тот который счет нужным
//        return logInButtonLocator;
//    }

    // Блок атомарных методов //поиск элементов // теперь находим элемент и сразу проверяем на отображение (waitsService)/используем ток в том случае если
//    public UIElement getEmailInput() { return new UIElement(driver, emailInputLocator);}
//    public UIElement getPassword() { return new UIElement(driver, passwordInputLocator);}
//    public UIElement getLogInButton() { return new UIElement(driver, logInButtonLocator);}
//    public UIElement getErrorTextElement() { return new UIElement(driver, errorTextLocator);}


    //новая версия,с page factory не работают обертки (

    // Блок описания локаторов для эментов
    @FindBy(id = "name")
    public WebElement emailInput;
    @FindBy(id = "password")
    public WebElement passwordInput;
    @FindBy(id = "button_primary")
    public WebElement logInButton;
    @FindBy(className = "error-text")
    public WebElement errorText;

    // Блок иницализации страницы
//    public LoginPage(WebDriver driver) {
//        super(driver);
//    }

}
