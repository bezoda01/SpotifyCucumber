package selen.browser;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

import static selen.Loggerr.log;
import static selen.driver.Driver.getDriver;
import static selen.settings.Settings.settings;
import static utils.FileUtils.copy;

public class Browser {

    public void quit() {
        getDriver().quit();
        log("driver was killed");
    }

    public void close() {
        getDriver().close();
        log("current window was close");
    }

    public void goTo(String url) {
        getDriver().get(url);
        log("go to " + url);
    }

    public void goTo() {
        String url = settings.get("url").toString();
        getDriver().get(url);
        log("go to " + url);
    }

    public String getCurrentUrl() {
        log("return current url");
        return getDriver().getCurrentUrl();
    }

    public String getPageSource() {
        log("return current page source");
        return getDriver().getPageSource();
    }

    public void switchToNewWindow() {
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        log("switch to new window");
    }

    public void switchToNewTab() {
        getDriver().switchTo().newWindow(WindowType.TAB);
        log("switch to new tab");
    }

    public void switchToFrame(String locator) {
        getDriver().switchTo().frame(locator);
        log("switch to frame with locator - " + locator);
    }

    public String getPageTitle() {
        String title = getDriver().getTitle();
        log("return page title - " + title);
        return title;
    }

    public void addCookie(Cookie cookie) {
        getDriver().manage().addCookie(cookie);
        log(
                "cookie name - " + cookie.getName() +
                        "\ncookie value - " + cookie.getValue());
    }

    public Set<Cookie> getCookies() {
        return getDriver().manage().getCookies();
    }

    public void deleteCookie(String name) {
        getDriver().manage().deleteCookieNamed(name);
        log("deleted cookie - " + name);
    }

    public void deleteCookie() {
        for (Cookie cookie : getCookies()) {
            log(
                    "deleted cookie - "
                            + cookie.getName() + ":"
                            + cookie.getValue());
        }
        getDriver().manage().deleteAllCookies();
    }

    public WebDriver.Window window() {
        return getDriver().manage().window();
    }

    public boolean makeScreenShot(String name) {
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File pathToSS = new File(settings.get("pathToScreenFolder") + name + ".png");
        copy(scrFile, pathToSS.getAbsolutePath());
        return pathToSS.exists();
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] makeScreenShotByByte(String name) {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public String getHostName() {
        InetAddress addr = null;
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return addr.getHostName();
    }
}