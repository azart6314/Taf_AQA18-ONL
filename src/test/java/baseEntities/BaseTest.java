package baseEntities;

import Factory.BrowserFactory;
import Utils.InvokedListener;
import configuration.ReadProperties;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.WaitsService;
import steps.UserStep;

@Listeners(InvokedListener.class)

public class BaseTest {

    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;



    @BeforeMethod
    public void setUp(ITestContext iTestContext) {   /*ITestContext   iTestContext  сделано для снятия скринов при ошибка */
        driver = new BrowserFactory().getDriver();
        driver.get(ReadProperties.getUrl());
        waitsService = new WaitsService(driver);

        //Solution1     //сделано тоже для скринов в InvokedListener
        iTestContext.setAttribute("driver", driver);
        //Solution1 - Finish

        userStep = new UserStep(driver);
        System.out.println(driver.hashCode());

    }

    @AfterMethod
    public void tearDown(ITestResult testResult) { //ITestResult testResult также все для скиринов
        // Solution -2: Плохое решение - потому что Screenshot добавляется в шаг TearDown
        /* if (testResult.getStatus()== ITestResult.FAILURE){
        try {
        byt[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(srcFile);
        } catch (NiSuchSessionException ex) {
        }
        }
         */

        driver.quit();
    }

    // Solution -2
    @Attachment(value = "Page screenshot", type = "image/png") // этот метод для картинки
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
