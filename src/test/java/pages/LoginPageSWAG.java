package pages;

import baseEntities.BasePageSWAG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageSWAG extends BasePageSWAG {


    //блок описания локаторов для элементов  (обычно приветные финальные значения для by) ( в этот блок вносим только те элементы которые относятся только к этой странице и ничего больше )
    private final By userNameInputLocator = By.id("user-name");
    private final By passwordInputLocator =By.id("password");
    private final By loginButtonLocator =By.name("login-button");


    //блок инициализаций страницы
    public LoginPageSWAG(WebDriver driver) {
        super(driver);
    }

    //блок отомарных методов (методы которые позваляют нам получить элемент или сделать какое то одно простое действие)
    public WebElement getNameInput() { return driver.findElement(userNameInputLocator);}
    public WebElement getPasswordInputLocator() { return driver.findElement(passwordInputLocator);}
    public WebElement getLoginButtonLocator() { return driver.findElement(loginButtonLocator);}

}
