package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserRegistration {

    WebDriver driver;
    String radio_male = "id_gender1";
    String radio_female = "id_gender2";
    String id_input_emailAddress = "email_create";
    String xpath_button_SignIn = "//a[@class='login']";
    String id_button_CreateAnAccount = "SubmitCreate";
    String id_input_firstName = "customer_firstname";
    String id_input_lastName = "customer_lastname";
    String id_input_password = "passwd";
    String id_dropdown_days = "days";
    String id_dropdown_months = "months";
    String id_dropdown_years = "years";
    String id_button_Register = "submitAccount";

    public UserRegistration(WebDriver driver){
        this.driver = driver;
    }

    public void navigateToShoppingPortal() {
        System.out.println("navigateToShoppingPortal");
        driver.get("http://www.automationpractice.pl/");
    }

    public void navigateToSignInTab() {
        System.out.println("navigateToSignInTab");
        WebElement signInButton = driver.findElement(By.xpath(xpath_button_SignIn));
        signInButton.click();
    }

    public void enterEmailAddress(String email) {
        WebElement emailInput = driver.findElement(By.id(id_input_emailAddress));
        emailInput.sendKeys(email);
    }

    public void clickClickAnAccountButton() {
        WebElement createAccountButton = driver.findElement(By.id(id_button_CreateAnAccount));
        createAccountButton.click();
    }

    public void enterUserDetails(String firstName, String lastName, String gender, String password, String DOB) {
        selectGender(gender);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPassword(password);
        selectDateOfBirth(DOB);
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameInput = driver.findElement(By.id(id_input_firstName));
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(By.id(id_input_lastName));
        lastNameInput.sendKeys(lastName);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(By.id(id_input_password));
        passwordInput.sendKeys(password);
    }

    public void selectGender(String gender) {
        if(gender.equalsIgnoreCase("Male")) {
            driver.findElement(By.id(radio_male)).click();
        }
        else {
            driver.findElement(By.id(radio_female)).click();
        }
    }

    public void selectDateOfBirth(String DOB) {
        String[] arrDOB = DOB.split("-");
        WebElement day_value = driver.findElement(By.id(id_dropdown_days));
        WebElement month_value = driver.findElement(By.id(id_dropdown_months));
        WebElement year_value = driver.findElement(By.id(id_dropdown_years));
        Select day = new Select(day_value);
        Select month = new Select(month_value);
        Select year = new Select(year_value);
        day.selectByValue(arrDOB[0]);
        month.selectByIndex(Integer.parseInt(arrDOB[1]));
        year.selectByValue(arrDOB[2]);
    }

    public void clickRegisterButton() {
        WebElement register_Button = driver.findElement(By.id(id_button_Register));
        register_Button.click();
    }

    public void verifyPersonalInformationPage() {
        WebElement personalInformationPage = driver.findElement(By.xpath("//*[text()='Your personal information']"));
        Assert.assertTrue(personalInformationPage.isDisplayed());
    }


}
