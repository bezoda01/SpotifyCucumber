package selen.base.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selen.actions.IActions;
import selen.js.JSMethods;
import selen.waits.ExplicitWaits;
import selen.waits.TypeWait;

import java.util.ArrayList;
import java.util.List;

import static selen.Loggerr.log;
import static selen.driver.Driver.getDriver;

public class BaseElement {

    private By locator;
    private WebElement element;
    private String name;
    private TypeWait typeWait;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    public BaseElement(By locator, String name, TypeWait typeWait) {
        this.locator = locator;
        this.name = name;
        this.typeWait = typeWait;
    }

    public BaseElement(WebElement element) {
        this.element = element;
    }

    public BaseElement(WebElement element, String name) {
        this.element = element;
        this.name = name;
    }

    protected WebElement findElement(TypeWait typeWait) {
        log("Search element - " + name);
        if (typeWait.name().equals(TypeWait.PRESENCE_OF_ELEMENT_LOCATED.name())) {
            return waits().presenceOfElementLocated();
        } else {
            return waits().elementToBeClickable();
        }
    }

    protected WebElement findElement() {
        log("Search element - " + name);
        if (typeWait == null) {
            return getDriver().findElement(locator);
        } else {
            return findElement(typeWait);
        }
    }

    protected List<WebElement> findElements() {
        return getDriver().findElements(locator);
    }

    protected List<WebElement> findElements(TypeWait typeWait) {
        log("Search element - " + name);
        if (typeWait.name().equals(TypeWait.LIST_PRESENCE_OF_ELEMENT_LOCATED.name())) {
            return waits().listPresenceOfElementLocated();
        } else {
            return findElements();
        }
    }

    protected <T> List<T> getElements(Class<T> tClass) {
        log("Search elements - " + name);
        List<T> listElements = new ArrayList<>();
        for (WebElement element : findElements(typeWait)) {
            if (tClass.equals(TextField.class)) {
                listElements.add((T) new TextField(element, name));
            } else if (tClass.equals(Button.class)) {
                listElements.add((T) new Button(element, name));
            }
        }
        return listElements;
    }

    public void click() {
        log("Click on - " + name);
        if (locator == null) {
            element.click();
        } else {
            findElement().click();
        }
    }

    public String getText() {
        log("Return field " + name + " text - " + element.getText());
        if (locator == null) {
            return element.getText();
        } else {
            return findElement().getText();
        }
    }

    public String getAttribute(String attribute) {
        log("Return attribute value - " + name);
        if (locator == null) {
            return element.getAttribute(attribute);
        } else {
            return findElement().getAttribute(attribute);
        }
    }

    public IActions actions() {
        return new IActions(findElement());
    }

    public JSMethods jsMethods() {
        if (element == null) {
            return new JSMethods(findElement());
        } else {
            return new JSMethods(element);
        }
    }

    public boolean isDisplayed() {
        if (element == null) {
            return findElement().isDisplayed();
        } else {
            return element.isDisplayed();
        }
    }

    public boolean isEnabled() {
        if (element == null) {
            return findElement().isEnabled();
        } else {
            return element.isEnabled();
        }
    }

    public ExplicitWaits waits() {
        return new ExplicitWaits(locator, element);
    }

    public By getLocator() {
        return locator;
    }

    public String getName() {
        return name;
    }

    public WebElement getElement() {
        return element;
    }
}