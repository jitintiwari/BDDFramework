package stepDefinitions;

import driverFactory.TestContextSetup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.BankAccount;

public class BankAccount_StepDefinition {

    TestContextSetup testContext;
    BankAccount bankAccount;

    public BankAccount_StepDefinition(TestContextSetup testContext) {
        this.testContext = testContext;
        this.bankAccount = testContext.getBankAccountObj();
    }

    @Given("I have a balance of $ {int} in my account")
    public void i_Have_A_Balance_Of_$_In_My_Account(int balance) {
        bankAccount.depositAmount(balance);
    }

    @And("Account balance will be $ {int}")
    public void accountBalanceWillBe$(int remainingBalance) {
        Assert.assertEquals("Remaining balance not equal", bankAccount.getRemainingBalance(), remainingBalance);
    }
}
