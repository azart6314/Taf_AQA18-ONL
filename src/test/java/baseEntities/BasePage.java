package baseEntities;

import configuration.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import services.WaitsService;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitsService waitsService; //иницилиазируем класс ожиданий и вконструкторе базовом( теперь дотупен во всех баз класссах)

    public BasePage(WebDriver driver) {
        this.driver = driver;
        waitsService = new WaitsService(driver);

        PageFactory.initElements(driver, this);
    }

//    protected abstract By getPageIdentifier();
//
//    public boolean isPageOpened() {
//        return waitsService.waitForVisibilityBy(getPageIdentifier()).isDisplayed();
//    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }

}
