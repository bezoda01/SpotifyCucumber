package selen.js;

public enum JScripts {
    LOADSTATE("return document.readyState"),
    CLICK_ON_ELEMENT("arguments[0].click();");

    private final String value;

    JScripts(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}