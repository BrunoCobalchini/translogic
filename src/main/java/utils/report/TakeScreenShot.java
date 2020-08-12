package utils.report;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.browserManager.ChromeDriverManager;

public class TakeScreenShot extends ChromeDriverManager {

    public synchronized static byte[] getImageBytes(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
