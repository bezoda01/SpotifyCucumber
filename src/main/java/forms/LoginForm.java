package forms;

import org.openqa.selenium.By;
import selen.base.BaseForm;
import selen.base.elements.Button;
import selen.base.elements.TextField;
import selen.waits.TypeWait;

public class LoginForm extends BaseForm {

    private final TextField usernameField = getIFactory().getTextField(By.id("login-username"), "username field");
    private final TextField passwordField = getIFactory().getTextField(By.id("login-password"), "password field");
    private final Button logOnBtn = getIFactory().getButton(By.id("login-button"), "log on button");

    public LoginForm() {
        super(new TextField(By.xpath("//div[@data-testId = 'login-container']"), "login", TypeWait.PRESENCE_OF_ELEMENT_LOCATED));
    }

    public void inputUsername(String username) {
        usernameField.sendText(username);
    }

    public void inputPassword(String password) {
        passwordField.sendText(password);
        logOnBtn.click();
    }
}
