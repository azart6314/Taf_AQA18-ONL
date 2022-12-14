package tests.data;

import org.testng.annotations.DataProvider;

public class HWStaticProvider {

    @DataProvider(name = "dataForInt")
    public static Object[][] datsForIntTest() {
        return new Object[][]{
                {4, 2, 2},
                {8, 2, 4},
                {10, 2, 5},

        };
    }
}
