package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.StaticProvider;

public class DataProviderTest {
    Calculator calculator = new Calculator();

    @Test (dataProvider = "dataForSum", dataProviderClass = StaticProvider.class, threadPoolSize = 2) //dataProvider = "dataForSum" - имя дата провайдера. dataProviderClass = StaticProvider.class - указываем класс где содержиться этот метот
    public void testSum(int a, int b, int expected) {
        Assert.assertEquals(calculator.sum(a, b), expected, "Невернная сумма ...");
    }

}
