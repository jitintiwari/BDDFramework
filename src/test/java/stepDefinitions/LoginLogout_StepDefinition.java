package stepDefinitions;

import driverFactory.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginLogout;

public class LoginLogout_StepDefinition {

    WebDriver driver;
    TestContextSetup testContext;
    LoginLogout signIn;

    public LoginLogout_StepDefinition(TestContextSetup testContext) {
        this.testContext = testContext;
        this.driver = testContext.getDriver();
        this.signIn = testContext.getLoginLogoutObj();
    }

    @And("Enter email address {string}, password {string} and click on SignIn button")
    public void enter_Email_Address_Password_And_Click_On_SignIn_Button(String email, String password) {
        signIn.enterEmailAddressToLogin(email);
        signIn.enterPasswordToLogin(password);
        signIn.clickSignInButtonToLogin();
    }

    @Then("User should be logged in to account")
    public void user_Should_Be_LoggedIn_To_Account() {
        Assert.assertEquals("My Shop", driver.getTitle());
    }

    @When("User clicks on Sign out button")
    public void user_Clicks_On_SignOut_Button() {
        signIn.clickSignOutButton();
    }

    @Then("User should be logged out")
    public void user_Should_Be_LoggedOut() {
        Assert.assertEquals("Login - My Shop", driver.getTitle());
    }
}
