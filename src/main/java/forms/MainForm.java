package forms;

import base.driver.BaseForm;
import base.elements.Button;
import base.elements.TextField;
import org.openqa.selenium.By;

public class MainForm extends BaseForm {

    private final Button cookie = new Button(By.id("onetrust-close-btn-container"), "cookie");
    private final Button loginBtn = new Button(By.xpath("//div[@class = 'ButtonInner-sc-14ud5tc-0 iebPZv encore-inverted-light-set']"), "login button");
    private final Button searchBtn = new Button(By.xpath("//li[@class = 'eNs6P3JYpf2LScgTDHc6 InvalidDropTarget'][2]"), "search button");
    private final Button myLib = new Button(By.xpath("//div[@class = 'GlueDropTarget GlueDropTarget--tracks']"), "user media lib");

    public MainForm() {
        super(new TextField(By.xpath("//section[@data-testid='home-page']"), "UNIQUE element"), "UNIQUE element");
    }

    public void closeCookie() {
        cookie.clickBtn();
    }

    public void clickToLogOn() {
        loginBtn.clickBtn();
    }

    public void clickOnSearchBtn() {
        searchBtn.clickBtn();
    }

    public void clickOnUserMediaLib() {
        myLib.clickBtn();
    }
}
