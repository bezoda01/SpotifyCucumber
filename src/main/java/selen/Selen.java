package selen;

import org.openqa.selenium.WebDriver;
import selen.browser.Browser;

import static selen.driver.Driver.getDriver;

public class Selen {

    public static WebDriver driver() {
        return getDriver();
    }

    public static Browser browser() {
        return new Browser();
    }
}