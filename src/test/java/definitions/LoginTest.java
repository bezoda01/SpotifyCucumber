package definitions;

import forms.LoginForm;
import forms.MainForm;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;

import static base.driver.BrowserUtils.goTo;
import static base.driver.BrowserUtils.quit;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    public MainForm mainForm;
    public LoginForm loginForm;

    @Given("^User is on Main page$")
    public void user_is_on_Main_page() {
        setUpAndGoLoginPage();
    }

    @When("^User enters username as \"([^\"]*)\"$")
    public void user_enters_username_as(String arg1) {
        inputUsername(arg1);
    }

    @And("^User enters password as \"([^\"]*)\"$")
    public void user_enters_password_as(String arg1) {
        inputPassword(arg1);
    }

    @Then("^User should be able to login successfully$")
    public void user_should_be_able_to_login_successfully() {
        checkIsSuccessfull();
    }

    @Step("Set up and go login page")
    public void setUpAndGoLoginPage() {
        goTo();
        mainForm = new MainForm();
        assertTrue(mainForm.isDisplayed(), "main page was not open");
        mainForm.closeCookie();
        mainForm.clickToLogOn();
        loginForm = new LoginForm();
        assertTrue(loginForm.isDisplayed(), "media lib page was not open");
    }

    @Step("Input username")
    public void inputUsername(String username) {
        loginForm.inputUsername(System.getenv(username));
    }

    @Step("Input password")
    public void inputPassword(String password) {
        loginForm.inputPassword(System.getenv(password));
    }

    @Step("Check log on is successfully")
    public void checkIsSuccessfull() {
        assertTrue(mainForm.isDisplayed(), "Log on was not sucessfully");
        quit();
    }
}
