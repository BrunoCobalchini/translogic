package utils.report;

import utils.baseTest.BaseTest;
import utils.browserManager.ChromeDriverManager;

public class Reporter extends BaseTest {

    public static synchronized void addScreenshotToReport(String sMsg) {
        testScenario.get().log(sMsg);
        testScenario.get().attach(TakeScreenShot.getImageBytes(ChromeDriverManager.getDriver()), "image/png", "");
    }

    public static synchronized void addLogToReport(String sMsg) {
        testScenario.get().attach(sMsg, "text/plain", "");
    }

}
