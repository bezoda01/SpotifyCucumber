package selen.driver;

import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;

import java.util.ArrayList;
import java.util.Map;

import static selen.Loggerr.log;
import static selen.settings.Settings.*;
import static utils.JsonUtils.JSONObjectToMap;

public class DriverOptions {

    public AbstractDriverOptions<?> getOptions() {
        switch (settings.get("browserName").toString()) {
            case "chrome": {
                Map<String, Object> config = JSONObjectToMap((JSONObject) settings.get("chrome"));
                Map<String, Object> browser = JSONObjectToMap(chrome);
                ChromeOptions options = new ChromeOptions();
                ArrayList<String> op = new ArrayList<>();
                log("Added arguments in options:");
                for (String st: config.keySet()) {
                    if(config.get(st).equals("true")) {
                        op.add(browser.get(st).toString());
                        log("   "+browser.get(st).toString());
                    }
                }
                return options.addArguments(op);
            }
            case "firefox": {
                Map<String, Object> config = JSONObjectToMap((JSONObject) settings.get("firefox"));
                Map<String, Object> browser = JSONObjectToMap(firefox);
                FirefoxOptions options = new FirefoxOptions();
                ArrayList<String> op = new ArrayList<>();
                log("Added arguments in options:");
                for (String st: config.keySet()) {
                    if(config.get(st).equals("true")) {
                        op.add(browser.get(st).toString());
                        log("   "+browser.get(st).toString());
                    }
                }
                return options.addArguments(op);
            }
            default: {
                return null;
            }
        }
    }
}