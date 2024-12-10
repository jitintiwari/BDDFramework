package stepDefinitions;

import driverFactory.TestContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BankAccount;
import pages.CashWithdrawal;

public class CashWithdraw_StepDefinition {

    TestContextSetup testContext;
    CashWithdrawal cashWithdrawal;
    BankAccount bankAccount;

    public CashWithdraw_StepDefinition(TestContextSetup testContext) {
        this.testContext = testContext;
        bankAccount = testContext.getBankAccountObj();
        cashWithdrawal = testContext.getCashWithdrawalObj();
    }

    @When("I request $ {int}")
    public void i_Request_$(int amount) {
        Assert.assertTrue(bankAccount.getAccountBalance() >= amount);
        bankAccount.setRemainingBalance(bankAccount.getAccountBalance() - amount);
    }

    @Then("$ {int} should be dispensed")
    public void $_Should_Be_Dispensed(int amount) {
        cashWithdrawal.withdrawalAmount(amount);
    }
}
