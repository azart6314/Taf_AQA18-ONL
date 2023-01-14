package services;

import configuration.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitsService {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsService(WebDriver driver) {  // конструктор который по умолчанию ( значит что будет время среднее для ожидания для событий которое указано в конфик проперти тайм аут) родоначальник
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout()));
    }

    public WaitsService(WebDriver driver, Duration timeout) {  // расширенный конструкот
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout);
    }

    public WebElement waitForVisibilityBy(By by) { // не явное ожидание на отсутствие
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by)); //это заменяет файнд эмлемент
    }

    public boolean waitForElementInvisible(WebElement webElement) { // не явное ожидание на пресутствие
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public List<WebElement> waitForAllVisibleElementsLocatedBy(By locator) {     //явная ожидалка
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForExists(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement fluentWaitForElement (By by) {
        Wait<WebDriver> fluent = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))  //настрока времени на ожидание
                .pollingEvery(Duration.ofMillis(50)) //через какие милисикунды перепроверять (меньше 50 не имеет смылся ставить)
                .ignoring(NoSuchFieldError.class); // игнорировать ексепшен

        return fluent.until(driver -> driver.findElement(by));
    }



}
