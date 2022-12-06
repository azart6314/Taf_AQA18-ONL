package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {
    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Teach_me_skills\\avtomat\\CW1_QA_18_Onl\\Taf_AQA18-ONL\\src\\test\\resources\\chromedriver_win32.zip"); //указываем где хром драйвер
        return new ChromeDriver();
    }
}
