package selen.base;

import selen.base.elements.BaseElement;
import selen.base.elements.IFactory;
import selen.waits.ExplicitWaits;

public abstract class BaseForm {
    private BaseElement uniqueElement;

    public BaseForm(BaseElement uniqueElement) {
        this.uniqueElement = uniqueElement;
    }

    public ExplicitWaits.EWaitsForm waits() {
        return new ExplicitWaits.EWaitsForm(uniqueElement.getLocator(), uniqueElement.getElement());
    }

    public IFactory getIFactory() {
        return new IFactory();
    }

    public boolean isDisplayed() {
        return uniqueElement.isDisplayed();
    }

    public boolean isEnabled() {
        return uniqueElement.getElement().isEnabled();
    }
}