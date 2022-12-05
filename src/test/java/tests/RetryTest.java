package tests;

import Utils.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryTest extends BaseTest {
    private int attempt = 1;

    @Test (retryAnalyzer = Retry.class) //retryAnalyzer- спец антируб имя класса в котором указываем метод класса в котором
    public void flakyTest() {
        if (attempt == 3) {
            Assert.assertTrue(true);
        } else {
            attempt++;
            System.out.println("Attempt is: " + attempt);
            Assert.assertTrue(false);
        }
    }
}
