package hooks;

import driverFactory.TestContextSetup;

import io.cucumber.java.Before;
import io.cucumber.java.After;

import org.openqa.selenium.WebDriver;

public class Hooks {

    TestContextSetup testContext;
    static WebDriver driver;

    public Hooks(TestContextSetup testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp(){
        testContext.setupDriver();
        driver = testContext.getDriver();
        testContext.initializePageObjects(driver);
    }

    @After
    public void tearDown(){
        testContext.getDriver().quit();
    }
}
