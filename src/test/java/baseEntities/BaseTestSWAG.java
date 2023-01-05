package baseEntities;

import Factory.BrowserFactory;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestSWAG {

    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
