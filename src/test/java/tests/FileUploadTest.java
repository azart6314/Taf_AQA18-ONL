package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void fileUploaderTes() {
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUploadElement = waitsService.waitForExists(By.xpath("//input[@name='file']"));
        String wayToFile = ActionsTest.class.getClassLoader().getResource("Crazy.jpg").getPath().substring(1);
        fileUploadElement.sendKeys(wayToFile);
        waitsService.waitForVisibilityBy(By.id("file-submit")).submit();
        Assert.assertEquals(waitsService.waitForVisibilityBy(By.id("uploaded-files")).getText().trim(),"Crazy.jpg");

    }

}
