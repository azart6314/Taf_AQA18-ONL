package tests;

import Factory.AdvancedDriver;
import Factory.BrowserFactory;
import Factory.SimpleDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SimpleWDTest {

    @Test
    public void simpleWDTest() {
        SimpleDriver simpleDriver = new SimpleDriver();
        WebDriver driver = simpleDriver.getDriver();
        driver.quit();  //секция закрывает браузер если нету команды в диспечере надо убить процесс
    }
    @Test
    public void advancedWDTest() {
        AdvancedDriver advanceDriver = new AdvancedDriver();
        WebDriver driver = advanceDriver.getDriver();
        driver.quit();
    }

    @Test
    public void browserFactoryWDTest() {
        BrowserFactory browserFactory = new BrowserFactory();
        WebDriver driver = browserFactory.getDriver();
        driver.quit();
    }

}
