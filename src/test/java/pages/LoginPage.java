package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    //блок описания локатора для элемента
    private final By emailInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.name("login-button");

    //Блок инициализаций страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return loginButtonLocator; //сюда самый медленный или тот который мы считаем самым нужным
    }

    //Блок атомарных методов
    public WebElement getEmailInput() {return driver.findElement(emailInputLocator);}
    public WebElement getPassword() {return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButton() {return driver.findElement(loginButtonLocator);}




}
