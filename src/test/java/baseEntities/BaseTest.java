package baseEntities;

import Factory.BrowserFactory;
import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import services.WaitsService;
import steps.ProjectSteps;
import steps.UserStep;
@Listeners()
public class BaseTest {

    protected WebDriver driver;
    protected UserStep userStep;
    protected WaitsService waitsService;
    protected ProjectSteps projectSteps;



    @BeforeMethod
    public void setUp(ITestContext iTestContext) {   /*ITestContext   iTestContext  сделано для снятия скринов при ошибка */
        driver = new BrowserFactory().getDriver();
        waitsService = new WaitsService(driver);
        driver.get(ReadProperties.getUrl());


        //Solution1     //сделано тоже для скринов в InvokedListener
        iTestContext.setAttribute("driver", driver);
        //Solution1 - Finish

        userStep = new UserStep(driver);
        //System.out.println(driver.hashCode());
        projectSteps = new ProjectSteps(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult testResult) { //ITestResult testResult - для скринов
        driver.quit();
    }
}
