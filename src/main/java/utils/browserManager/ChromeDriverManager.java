package utils.browserManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static utils.properties.PropertiesHelper.*;

public class ChromeDriverManager {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){
        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    public static WebDriver initDriver() {
        WebDriver driver = null;
        if(executionType.equals("grid")) {
            System.out.println("--GRID--");
            try {
                driver = new RemoteWebDriver(new URL(urlSeleniumGRID), chromeOptions());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("--LOCAL--");
            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", pathToWebDriver + "chromedriver.exe");
                driver = new ChromeDriver(chromeOptions());
            } else if (browser.equals("internetExplorer")) {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.
                        INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
                System.setProperty("webdriver.ie.driver", pathToWebDriver + "IEDriverServer.exe");
                driver = new InternetExplorerDriver(capabilities);
            }
        }
        return driver;
    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static void quitDriver() {
        WebDriver driver = getDriver();
        if(driver != null) {
            driver.quit();
        }
        if(threadDriver != null) {
            threadDriver.remove();
        }
    }

    public static ChromeOptions chromeOptions () {
        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromePrefs = new HashMap<>();

        //chromePrefs.put("download.prompt_for_download", "false");

        options.addArguments("start-maximized");
        //options.addArguments("--headless");
        //options.setExperimentalOption("prefs", chromePrefs);

        return options;
    }

}
