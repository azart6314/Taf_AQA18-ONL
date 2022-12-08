package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.HWCalculator;

import java.util.List;

public class HWCalculatorTest extends BaseTest {

    @Test(timeOut = 100,description = "Рукописное описание")
    public void sum1() {
        Assert.assertEquals(HWCalculator.sum(5, 5),10,"Тест пройден");
    }

    @Test(enabled = false, priority = 1)
    public void sum001() {
        Assert.assertEquals(HWCalculator.sum(11, 19),30,"Тест пройден");
    }

     @Test(priority = 1, dependsOnMethods = "sum1")
    public void sum2() {
        Assert.assertEquals(HWCalculator.sum(-1,-1), -2,"Тест пройден");
    }

    @Test (priority = 2) // будет в конце так как у все по дефолту 0
    public void sum3() {
        Assert.assertEquals(HWCalculator.sum(-1,3), 2,"Тест пройден");
    }

    @Test(invocationCount = 3, invocationTimeOut = 500, threadPoolSize = 2)
    public void sum4() {
        Assert.assertEquals(HWCalculator.sum(0, 0), 0, "Тест пройден");
    }

    @Test(description = "Вся каша", priority = 1,dependsOnMethods = "sum1", alwaysRun = true, groups = "Нема", timeOut = 500,
    invocationCount = 2, invocationTimeOut = 900, threadPoolSize = 2)
    public void sum5() {
        Assert.assertEquals(HWCalculator.sum(3, -4), -1,"Тест пройден");
    }

    @Test
    public void sum6() {
        Assert.assertEquals(HWCalculator.sum(3, 0), 3,"Тест пройден");
    }

    /////////////////////////////////////////////
    ////////////////////////////////////////////
    ///////////////////////////////////////////
    //////////////////////////////////////////

    @Test (enabled = true, description = "Рукописное описание", priority = 0, dependsOnMethods = "sum6", alwaysRun = true)
    public void divDouble() {
        Assert.assertEquals(HWCalculator.divDouble(2.5,1), 2.5, "Тест пройден");
    }

    @Test(groups = "1", timeOut = 500)
    public void divDouble1() {
        Assert.assertEquals(HWCalculator.divDouble(10,2), 5, "Тест пройден");
    }

    @Test(dependsOnGroups = "1")
    public void divDouble2() {
        Assert.assertEquals(HWCalculator.divDouble(10,2.5), 4, "Тест пройден");
    }


    @Test(priority = 2, invocationCount = 2, invocationTimeOut = 500, threadPoolSize = 2)
    public void divDouble4() throws InterruptedException {
        Assert.assertEquals(HWCalculator.divDouble(0.9,2), 0.45, "Тест пройден");
        Thread.sleep(500);
    }

    @Test
    public void divDouble5() {
        Assert.assertEquals(HWCalculator.divDouble(0,3), 0, "Тест пройден");
    }

    @Test
    public void divDouble6() {
        Assert.assertEquals(HWCalculator.divDouble(-5,3), -1.6666666666666667, "Тест пройден");
    }



//    @Test(expectedExceptions = NullPointerException.class)
//    public void divDouble7() {
//        Assert.assertEquals(HWCalculator.divDouble(3.0,0), 0, "Тест пройден");
//        List list = null;
//        double expected = list.size(); //les 4 30m
//    }



    @Test
    public void divInt1() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }

    @Test(dependsOnMethods = "divInt1",invocationCount = 3, invocationTimeOut = 1000, threadPoolSize = 2)
    public void divInt2() throws InterruptedException {
        Assert.assertEquals(HWCalculator.divInt(-10, 2), -5, "Тест пройден");
        Thread.sleep(1000);
    }

    @Test
    public void divInt3() {
        Assert.assertEquals(HWCalculator.divInt(10, -2), -5, "Тест пройден");
    }

//    @Test(expectedExceptions = NullPointerException.class)
//    public void divInt4() {
//        Assert.assertEquals(HWCalculator.divInt(20, 2), 10, "Тест пройден");
//    }

    @Test
    public void divInt4() {
        Assert.assertEquals(HWCalculator.divInt(10, 2), 5, "Тест пройден");
    }






}
