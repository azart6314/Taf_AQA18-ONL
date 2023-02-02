package pages.projekt;

import baseEntities.BasePage;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "index.php?/admin/projects/add";

    private final By addProjectButtonLocator = By.id("accept");
    private final By nameInputLocator = By.id("name");

    public AddProjectPage(WebDriver driver) {
        super(driver);
    }


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }

    public WebElement getNameInput() {
        return driver.findElement(nameInputLocator);
    }

    public RadioButton getType() {
        return new RadioButton(driver, "suite_mode");
    }
}
