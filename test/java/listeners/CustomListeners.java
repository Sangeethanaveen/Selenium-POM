package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import test.SpreeBase;

import java.io.IOException;

public class CustomListeners extends SpreeBase implements ITestListener {
    @Override
    public void onFinish(ITestContext result) {
        // TODO Auto-generated method stub
        System.out.println("***** FINISH TEST *****:" + result.getName());
    }

    @Override
    public void onStart(ITestContext result) {
        // TODO Auto-generated method stub
        System.out.println("*****STARTED TEST*****:" + result.getName());

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        /* TODO Auto-generated method stub */
        System.out.println("***** FAILED SUCCESS PERCENTAGE *****:" + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("***** FAILED TEST *****:" + result.getName());
        try {
            takeSnapShot(driver, System.getProperty("user.dir") + "/" + "src/screenshots");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("***** SKIPPED TEST *****:" + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println("***** SUCCESS TEST*****:" + result.getName());

    }
}