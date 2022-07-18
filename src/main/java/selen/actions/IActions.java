package selen.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static selen.driver.Driver.getDriver;

public class IActions {
    private Actions actions;
    private WebElement element;

    public IActions (WebElement element) {
        actions = new Actions(getDriver());
        this.element = element;
    }
    public void moveToElement() {
        actions.moveToElement(element).build().perform();
    }
}