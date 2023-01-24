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

public class WaitsService { //класс в которы добавляем все ожидания //иницилизируем клас и используем в Base pages
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitsService(WebDriver driver) {  // конструктор который по умолчанию ( значит что будет время среднее для ожидания для событий которое указано в конфик проперти тайм аут) родоначальник
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.timeout())); //родоночальник явных ожиданий
    }

    public WaitsService(WebDriver driver, Duration timeout) {  // расширенный конструкот для не явн ожид
        this.driver = driver;
        wait = new WebDriverWait(driver, timeout); //перед драйвер и время каоторо епридет
    }
    //иницилизируем клас и используем в атомарных методах (BY)
    public WebElement waitForVisibilityBy(By by) {//поиск и проверка на отображения элемента на странице (именно на экране visibility)
       return wait.until(ExpectedConditions.visibilityOfElementLocated(by));//это заменяет файнд эмлемент а) поиск элемента б)что он отображается после чего он вернет этот элемент
    }

    //ожидалка что элемент не видимы становиться(исчез)
    public boolean waitForElementInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));//делаем проверку по веб элементу(могем по локатору но тут такое себе )
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
