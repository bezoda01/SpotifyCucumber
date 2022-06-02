package base.driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;

import static base.driver.Loggerr.log;

public class AlertsUtils {
    private static Alert alert;

    public static void switchToAlert() {
        alert = WaitUtils.waitAlert();
    }

    public static String getWords() {
        switchToAlert();
        log("Берём текст Alert.");
        return alert.getText();
    }

    public static void acceptAlert() {
        switchToAlert();
        log("Alert принимается.");
        alert.accept();
    }

    public static void dismissAlert() {
        log("Alert отменяется.");
        alert.dismiss();
    }

    public static void sendAlert(String text) {
        switchToAlert();
        log("Вводится текст в Alert");
        alert.sendKeys(text);
    }

    public static Boolean alertIsClose() {
        boolean close = false;
        try {
            switchToAlert();
        }catch (TimeoutException e) {
            close = true;
        }
        return close;
    }
}
