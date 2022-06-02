package base.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import static base.driver.Loggerr.*;

public class Options {

    public static AbstractDriverOptions<?> getOptions(String ... op) {
        switch (System.getenv("BROWSER")) {
            case ("chrome"): {
                ChromeOptions options = new ChromeOptions();
                for(String s : op) {
                    options.addArguments(s);
                    log("add option: " + s);
                }
                return options;
            }
            case ("firefox"): {
                FirefoxOptions options = new FirefoxOptions();
                for(String s : op) {
                    options.addArguments(s);
                    log("add option: " + s);
                }
                return options;
            }
            case ("opera"): {
                OperaOptions options = new OperaOptions();
                for(String s : op) {
                    options.addArguments(s);
                    log("add option: " + s);
                }
                return options;
            }
            default: {
                log("This browser do not support: \nsupport browser list: chrome opera firefox");
                throw new IllegalArgumentException();
            }
        }

    }
}
