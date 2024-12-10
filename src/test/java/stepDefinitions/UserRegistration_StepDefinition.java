package stepDefinitions;

import driverFactory.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.UserRegistration;

public class UserRegistration_StepDefinition {

    WebDriver driver;
    TestContextSetup testContext;
    UserRegistration register;

    public UserRegistration_StepDefinition(TestContextSetup testContext){
        this.testContext = testContext;
        this.driver = testContext.getDriver();
        this.register = testContext.getUserRegistrationObj();
    }


    @Given("Shopping home page is displayed")
    public void shopping_home_page_is_displayed() {
        register.navigateToShoppingPortal();
        Assert.assertEquals("My Shop", driver.getTitle());
        System.out.println("shopping home page is displayed");
    }

    @When("User navigates to SignIn tab")
    public void user_Navigates_To_SignIn_Tab() {
        register.navigateToSignInTab();
    }

    @And("Enter {string} email address in input")
    public void enter_Email_Address_In_Input(String emailAddress) {
        register.enterEmailAddress(emailAddress);
    }

    @Then("User's account home page should be displayed")
    public void users_account_home_page_should_be_displayed() {
        Assert.assertEquals("My account - My Shop", driver.getTitle());
    }

    @And("Click Create An Account button")
    public void click_Create_An_Account_Button() {
        register.clickClickAnAccountButton();
    }

    @Then("Personal information page should be displayed")
    public void personal_Information_Page_Should_Be_Displayed() throws InterruptedException {
        Thread.sleep(2000);
        register.verifyPersonalInformationPage();
    }

    @And("Click on Register button")
    public void click_On_RegisterButton() {
        register.clickRegisterButton();
    }

    @When("User provides first name {string}, last name {string}, gender {string}, password {string} and date of birth in dd-mm-yyyy format {string}")
    public void user_Provides_FirstName_LastName_Gender_Password_And_DateOfBirth_In_DdMmYyyy_Format(String firstName, String lastName, String gender, String password, String DOB) {
        register.enterUserDetails(firstName, lastName, gender, password, DOB);
    }
}
