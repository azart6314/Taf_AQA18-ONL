package Utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    @Override //делает скиршоты при ошибках ( но есть проблемы с именно этим лисенором  )
    public void onTestFailure(ITestResult result) {
        System.out.println("Make a screenshot");
    }

}
