package selen.base.elements;

import org.openqa.selenium.By;
import selen.waits.TypeWait;

import java.util.List;

public class IFactory {

    public TextField getTextField(By locator, String message) {
        return new TextField(locator, message);
    }

    public TextField getTextField(By locator, String message, TypeWait typeWait) {
        return new TextField(locator, message, typeWait);
    }

    public List<TextField> getTextFields(By locator, String message) {
        return new TextField(locator, message).getElements(TextField.class);
    }

    public List<TextField> getTextFields(By locator, String message, TypeWait typeWait) {
        return new TextField(locator, message, typeWait).getElements(TextField.class);
    }

    public Button getButton(By locator, String message) {
        return new Button(locator, message);
    }

    public Button getButton(By locator, String message, TypeWait typeWait) {
        return new Button(locator, message, typeWait);
    }

    public List<Button> getButtons(By locator, String message) {
        return new Button(locator, message).getElements(Button.class);
    }

    public List<Button> getButtons(By locator, String message, TypeWait typeWait) {
        return new Button(locator, message, typeWait).getElements(Button.class);
    }
}