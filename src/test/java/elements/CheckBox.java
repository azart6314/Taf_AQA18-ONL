package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {
    private UIElement uiElement;

    public CheckBox(WebDriver driver, String attributeNameValue) {
        uiElement = new UIElement(driver, driver.findElement(By.name(attributeNameValue)));
    }

    public void unselect() {
        if(uiElement.isSelected()) {
            uiElement.click();
        }
    }

    public void select() {
        if (!uiElement.isSelected()) {
            uiElement.click();
        }
    }


}
