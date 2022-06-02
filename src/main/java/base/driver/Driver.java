package base.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

import static base.driver.Loggerr.log;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getInstance();
        }
        return driver;
    }

    private static WebDriver getInstance() {
        switch (System.getenv("BROWSER")) {
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                log("Create chrome driver");
                return new ChromeDriver((ChromeOptions) Options.getOptions(System.getenv("OPTIONS").split(" ")));
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                log("Create firefox driver");
                return new FirefoxDriver((FirefoxOptions) Options.getOptions(System.getenv("OPTIONS").split(" ")));
            }
            case "opera": {
                WebDriverManager.operadriver().setup();
                log("Create opera driver");
                return new OperaDriver((OperaOptions) Options.getOptions(System.getenv("OPTIONS").split(" ")));
            }
            default: {
                log("This browser do not support: \nsupport browser list: chrome opera firefox");
                throw new IllegalArgumentException();
            }
        }
    }
}
