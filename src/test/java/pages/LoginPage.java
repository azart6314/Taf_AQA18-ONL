package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов Блок описания локаторов для эментов (обычно приветные финальные значения для by) ( в этот блок вносим только те элементы которые относятся только к этой странице и ничего больше )
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {  //обычно выдирается самый медленный для загрузки метод или тот который счет нужным
        return logInButtonLocator;
    }

    // Блок атомарных методов //поиск элементов
    public WebElement getEmailInput() { return waitService.waitForVisibilityBy(emailInputLocator);}
    public WebElement getPassword() { return waitService.waitForVisibilityBy(passwordInputLocator);}
    public WebElement getLogInButton() { return waitService.waitForVisibilityBy(logInButtonLocator);}
    public WebElement getErrorTextElement() { return waitService.waitForVisibilityBy(errorTextLocator); }
}
