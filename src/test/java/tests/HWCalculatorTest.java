package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.HWCalculator;
import tests.data.StaticProvider;

import java.util.List;

public class HWCalculatorTest extends BaseTest {

//    @Test(timeOut = 100, description = "Рукописное описание")
//    public void sum1() {
//        Assert.assertEquals(HWCalculator.sum(5, 5), 10, "Тест пройден");
//    }
//
//    @Test(enabled = false, priority = 1)
//    public void sum001() {
//        Assert.assertEquals(HWCalculator.sum(11, 19), 30, "Тест пройден");
//    }
//
//    @Test(priority = 1, dependsOnMethods = "sum1")
//    public void sum2() {
//        Assert.assertEquals(HWCalculator.sum(-1, -1), -2, "Тест пройден");
//    }
//
//    @Test(priority = 2) // будет в конце так как у все по дефолту 0
//    public void sum3() {
//        Assert.assertEquals(HWCalculator.sum(-1, 3), 2, "Тест пройден");
//    }
//
//    @Test(invocationCount = 3, invocationTimeOut = 500, threadPoolSize = 2)
//    public void sum4() {
//        Assert.assertEquals(HWCalculator.sum(0, 0), 0, "Тест пройден");
//    }
//
//    @Test(description = "Вся каша", priority = 1, dependsOnMethods = "sum1", alwaysRun = true, groups = "Нема", timeOut = 500,
//            invocationCount = 2, invocationTimeOut = 900, threadPoolSize = 2)
//    public void sum5() {
//        Assert.assertEquals(HWCalculator.sum(3, -4), -1, "Тест пройден");
//    }
//
//    @Test
//    public void sum6() {
//        Assert.assertEquals(HWCalculator.sum(3, 0), 3, "Тест пройден");
//    }

    /////////////////////////////////////////////
    ////////////////////////////////////////////
    ///////////////////////////////////////////
    //////////////////////////////////////////
    @Test
    public void divInt() {
        Assert.assertEquals(HWCalculator.divInt(2147483647, 2147483647), 1, "Тест пройден");
    }

    @Test
    public void divInt1() {
        Assert.assertEquals(HWCalculator.divInt(-2147483648, -2147483648), 1, "Тест пройден");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divInt2() {
        Assert.assertEquals(HWCalculator.divInt(20, 0), 0, "Деление на ноль невозможно");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divInt3() {
        Assert.assertEquals(HWCalculator.divInt(-20, 0), 0, "Деление на ноль невозможно");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void divInt4() {
        Assert.assertEquals(HWCalculator.divInt(0, 0), 0, "Деление на ноль невозможно");
    }

    @Test
    public void divInt5() {
        Assert.assertEquals(HWCalculator.divInt(0, 2), 0, "Тест пройден");
    }

    @Test
    public void divInt6() {
        Assert.assertEquals(HWCalculator.divInt(0, -2), 0, "Тест пройден");
    }

    @Test
    public void divInt7() {
        Assert.assertEquals(HWCalculator.divInt(20, 2), 10, "Тест пройден");
    }

    @Test
    public void divInt8() {
        Assert.assertEquals(HWCalculator.divInt(-20, 2), -10, "Тест пройден");
    }

    /////////////////////////////////////////////////////////////////////
    @Test
    public void divDouble() {
        Assert.assertEquals(HWCalculator.divDouble(1.7976931348623158e+308, 2.1), 8.56044349934436E307, "Тест пройден");
    }

    @Test
    public void divDouble1() {
        Assert.assertEquals(HWCalculator.divDouble(2.2250738585072014e-308, 3), 7.41691286169067E-309, "Тест пройден");
    }

    @Test
    public void divDouble2() {
        Assert.assertEquals(Double.NEGATIVE_INFINITY, -10.0 / 0);
    }

    @Test
    public void divDouble3() {
        Assert.assertEquals(HWCalculator.divDouble(0, 2.3), 0, "Тест пройден");
    }

    @Test
    public void divDouble4() {
        Assert.assertEquals(HWCalculator.divDouble(-5.9, 2.1), -2.8095238095238098, "Тест пройден");
    }

    ////////////////////
    @Test(enabled = false)
    public void divIntParam() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(description = "Описание теста")
    public void divIntParam1Description() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(priority = 1)
    public void divIntParam2Priority() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(priority = 1)
    public void divIntParam3Priority() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test
    public void divIntParam4DependsGlava() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(dependsOnMethods = "divIntParam4DependsGlava")
    public void divIntParam4DependsOnMethods() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(alwaysRun = true)
    public void divIntParam5AlwaysRun() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(groups = "smoke")
    public void divIntParam4groups() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(groups = "smoke1")
    public void divIntParam4groups1() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(groups = "smoke2")
    public void divIntParam5() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }




}







