package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BankAccount;
import pages.CashWithdrawal;
import pages.UserRegistration;
import pages.LoginLogout;

import java.time.Duration;

public class TestContextSetup {

    WebDriver driver;

    public UserRegistration register;
    public LoginLogout signIn;
    public CashWithdrawal cashWithdrawal;
    public BankAccount bankAccount;

    public void setupDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public UserRegistration getUserRegistrationObj() {
        return register;
    }

    public LoginLogout getLoginLogoutObj() {
        return signIn;
    }

    public void initializePageObjects(WebDriver driver) {
        this.register = new UserRegistration(driver);
        this.signIn = new LoginLogout(driver);
        this.bankAccount = new BankAccount();
        this.cashWithdrawal = new CashWithdrawal();
    }

    public CashWithdrawal getCashWithdrawalObj() {
        return cashWithdrawal;
    }

    public BankAccount getBankAccountObj() {
        return bankAccount;
    }
}
