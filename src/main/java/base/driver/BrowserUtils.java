package base.driver;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;

import static base.driver.Driver.getDriver;
import static base.driver.Loggerr.log;
import static con.Constants.config;
import static utils.FileUtils.copy;

public class BrowserUtils {

    public static boolean makeScreenShot(String name) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File pathToSS = new File( config.get("pathScreen") + name + ".png");
        copy(scrFile, pathToSS.getAbsolutePath());
        return pathToSS.exists();
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] makeScreenShotByByte(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public static void close() {
        log("close");
        getDriver().close();
    }

    public static void quit() {
        log("TearDown");
        getDriver().quit();
    }

    public static void goTo() {
        log("Переходим - " + config.get("url").toString());
        getDriver().get(config.get("url").toString());
    }

    public static void goTo(String URN) {
        getDriver().get(config.get("url").toString() + URN);
    }

    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    public static String getHostName() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return addr.getHostName();
    }

    public static String getPageSource() {
        return getDriver().getPageSource();
    }

    public static LogEntries getBrowserLog() {
        return getDriver().manage().logs().get(LogType.BROWSER);
    }
}
