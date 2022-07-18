package selen.js;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static selen.driver.Driver.getDriver;
import static selen.js.JScripts.CLICK_ON_ELEMENT;

public class JSMethods {
    private JavascriptExecutor executor;
    private WebElement element;

    public JSMethods(WebElement element) {
        executor = (JavascriptExecutor) getDriver();
        this.element = element;
    }

    public JSMethods() {

    }

    public void executeScript(String script) {
        executor.executeScript(script);
    }

    public void executeScript(String script, Object ... arg) {
        executor.executeScript(script, arg);
    }

    public void clickOnElement() {
        executor.executeScript(CLICK_ON_ELEMENT.getValue(), element);
    }
}