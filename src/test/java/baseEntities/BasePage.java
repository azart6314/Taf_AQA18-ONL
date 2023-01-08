package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {    //класс создан для того что бы создовать в каждм тесте драйвер и делать проверку на страницах
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //после создания этих методов в pages надо имплементировать override метод
    protected abstract By getPageIdentifier(); //он якобы реализован и берем его ниже

    public boolean ipPageOpened() {   //метод который проверяет открылась ли страница один метод на все страницы
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }
}
