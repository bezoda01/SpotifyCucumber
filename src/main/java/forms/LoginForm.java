package forms;

import base.driver.BaseForm;
import base.elements.Button;
import base.elements.TextField;
import org.openqa.selenium.By;

public class LoginForm extends BaseForm {

    private final TextField usernameField = new TextField(By.id("login-username"), "username field");
    private final TextField passwordField = new TextField(By.id("login-password"), "password field");
    private final Button logOnBtn = new Button(By.id("login-button"), "log on button");

    public LoginForm() {
        super(new TextField(By.xpath("//div[@data-testId = 'login-container']"), "login"), "login");
    }

    public void inputUsername(String username) {
        usernameField.sendText(username);
    }

    public void inputPassword(String password) {
        passwordField.sendText(password);
        logOnBtn.clickBtn();
    }
}
