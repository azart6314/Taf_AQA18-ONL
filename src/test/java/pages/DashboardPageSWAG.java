package pages;

import baseEntities.BasePageSWAG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//эта страница чуть чуть отличается от LoginPage
public class DashboardPageSWAG extends BasePageSWAG {
    private final static String pagePage = "inventory-item.html?id=4"; //метод перехода по урлу (начало лежит в BasePageSWAG)

    private final By headerTitleLabelLocator = (By.xpath("//span[contains(text(), 'Products')]"));


    public DashboardPageSWAG(WebDriver driver) {
        super(driver);
    }

 public DashboardPageSWAG(WebDriver driver, boolean openPageByUrl) {     // конструтор сделанный для отрытия урла ( один из методов)
        super(driver);

        if (openPageByUrl) {
            openPageByUrl();
        }
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    public void openPageByUrl(){    //метод открытия страници финал от того что описано вверху
        super.openPageByUrl(pagePage);
    }
}
