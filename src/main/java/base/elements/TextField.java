package base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static base.driver.Loggerr.log;

public class TextField extends BaseElement {
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        log("Отправляем текст - " + text);
        findElement().sendKeys(text);
    }

    public void sendText(Keys keys) {
        log("Отправляем - " + keys.toString());
        findElement().sendKeys(keys);
    }
}
