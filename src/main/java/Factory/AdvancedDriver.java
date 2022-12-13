package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AdvancedDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver"); //относительный путь

        return new ChromeDriver(getChromeOptions());
    }

    public ChromeOptions getChromeOptions() {  //опцией браузера , предварительные настроки для вашего браузера
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(false);
        chromeOptions.addArguments("--disable-gpu"); //исключаю граф процес
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--silent");// бесшуный режим без лишних вопросов
        chromeOptions.addArguments("--start-maximized");

        return chromeOptions;
    }
}
