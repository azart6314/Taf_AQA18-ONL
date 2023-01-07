package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //блок описания локатора для элемента
    private final By emailNameInputLocator = By.id("user-name");
    private final By passwordInputLocator = By.id("password");
    private final By loginButtonLocator = By.name("login-button");


    //Блок инициализаций страницы


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Блок атомарных методов
    public WebElement getEmailInput() {return driver.findElement(emailNameInputLocator);}
    public WebElement getPassword() {return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButton() {return driver.findElement(loginButtonLocator);}




}
