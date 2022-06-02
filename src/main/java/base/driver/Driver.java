package base.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import static con.Constants.config;

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
                return new ChromeDriver();
            }
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            case "ie": {
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }
            case "opera": {
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            }
            default: {
                return null;
            }
        }
    }
}
