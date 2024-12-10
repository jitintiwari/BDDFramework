package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginLogout {

    WebDriver driver;

    String id_input_emailAddress = "email";
    String id_input_password = "passwd";
    String id_button_SignIn = "SubmitLogin";
    String xpath_button_SignOut = "//a[@class='logout']";

    public LoginLogout(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmailAddressToLogin(String email) {
        WebElement emailInput = driver.findElement(By.id(id_input_emailAddress));
        emailInput.sendKeys(email);
    }

    public void enterPasswordToLogin(String password) {
        WebElement passwordInput = driver.findElement(By.id(id_input_password));
        passwordInput.sendKeys(password);
    }

    public void clickSignInButtonToLogin() {
        WebElement signInButton = driver.findElement(By.id(id_button_SignIn));
        signInButton.click();
    }

    public void clickSignOutButton() {
        WebElement signOutButton = driver.findElement(By.id(xpath_button_SignOut));
        signOutButton.click();
    }
}
