package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePageSWAG {
    protected WebDriver driver;

    public BasePageSWAG(WebDriver driver) {
        this.driver = driver;
    }


    protected abstract By getPageIdentifier (); // создаем метод что бы могли проверять на то что открылась ли именно та страница ( тот элемент который мы выбрали для поиска на странице )

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }

    public void openPageByUrl(String pagePath) { //метод который открывает страницы по урлу // метод который передает сдлан в дашбордпаге
        driver.get(ReadProperties.getUrl() + pagePath);
    }
}
