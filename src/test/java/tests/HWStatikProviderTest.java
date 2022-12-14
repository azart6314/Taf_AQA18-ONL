package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.data.HWStaticProvider;

public class HWStatikProviderTest {
    HWCalculator hwCalculator = new HWCalculator();

    @Test(dataProvider = "dataForInt",dataProviderClass = HWStaticProvider.class)
    public void divIntParamDataProvider(int a, int b, int expected) {
        Assert.assertEquals(HWCalculator.divInt(a, b), expected, "Тест пройден");
    }
}
