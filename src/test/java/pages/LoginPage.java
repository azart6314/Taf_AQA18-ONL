package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class LoginPage extends BasePage {
    // Блок описания локаторов для эментов (обычно приветные финальные значения для by) ( в этот блок вносим только те элементы которые относятся только к этой странице и ничего больше )
    private final By emailInputLocator = By.id("name");
    private final By passwordInputLocator = By.id("password");
    private final By logInButtonLocator = By.id("button_primary");
    private final By errorTextLocator = By.className("error-text");

    // Блок иницализации страницы
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {   //обычно выдирается самый медленный для загрузки метод или тот который счет нужным
        return logInButtonLocator;
    }

    // Блок атомарных методов ( методы которые позваляют нам получить элемент или сделать нам одно простое действие)
    public WebElement getEmailInput() { return driver.findElement(emailInputLocator);}
    public WebElement getPassword() { return driver.findElement(passwordInputLocator);}
    public WebElement getLogInButton() { return driver.findElement(logInButtonLocator);}

    public WebElement errorTextElement() {return driver.findElement(errorTextLocator);}

}

