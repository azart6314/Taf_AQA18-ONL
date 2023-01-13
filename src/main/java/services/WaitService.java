package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitService {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitService(WebDriver driver) {  // конструктор который по умолчанию ( значит что будет время среднее для ожидания для событий которое указано в конфик проперти тайм аут) родоначальник
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public WaitService(WebDriver driver, Duration timeout) {  // расширенный конструкот
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibilityBy(By by) {
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); //это заменяет файнд эмлемент
    }

    public boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }


}
