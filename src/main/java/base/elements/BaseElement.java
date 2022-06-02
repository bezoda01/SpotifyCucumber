package base.elements;

import base.driver.Driver;
import base.driver.JavaScript;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

import static base.driver.Loggerr.log;

public abstract class BaseElement {
    private By element;
    private String name;

    public BaseElement(By locator, String name) {
        element = locator;
        this.name = name;
    }

    protected List<WebElement> findElements() {
        log("Поиск элементов - " + name);
        return Driver.getDriver().findElements(element);
    }

    protected WebElement findElement() {
        log("Поиск элементов - " + name);
        return explicitWait(element);
    }

    protected WebElement findElementWithFluent() {
        log("Поиск элементов - " + name);
        return fluentWait().until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(element);
            }
        });
    }

    public void clickBtn() {
        log("Кликаем на кнопку - " + name);
        findElement().click();
    }

    public void clickWithJS() {
        log("Кликаем на кнопку - " + name);
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", findElement());
    }

    public String getText() {
        log("Возвращаем текст поля - " + name);
        return findElement().getText();
    }

    public String[] getMasText() {
        log("Возвращение массива строк - " + name);
        List<WebElement> list = findElements();
        String temp = list.get(1).getText();
        String[] mas = temp.split("\n");
        return mas;
    }

    public String getTextAttribute(String attribute) {
        log("Возвращаем значение атрибута - " + name);
        return findElementWithFluent().getAttribute(attribute);
    }

    public Boolean isDisplayed() {
        log("Проверка существования элемента " + name);
        return findElement().isDisplayed();
    }

    public Boolean isEnabled() {
        log("Проверка существования элемента " + name);
        return findElement().isEnabled();
    }

    public boolean isElementPresent() {
        try {
            Driver.getDriver().findElement(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static WebElement explicitWait(By element) {
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(120))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void switchFrame() {
        log("Переключаемся во фрейм - " + name);
        Driver.getDriver().switchTo().frame(findElement());
    }

    public void frameReturn() {
        log("Возвращаемся в дефолтный документ ");
        Driver.getDriver().switchTo().defaultContent();
    }

    public static FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofMillis(5))
                .ignoring(NoSuchElementException.class);
    }

    public void executeScript(JavaScript javaScript) {
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript(javaScript.getScript(), findElement());
    }

    public void focusOnElement() {
        new Actions(Driver.getDriver()).moveToElement(findElement()).perform();
    }
}
