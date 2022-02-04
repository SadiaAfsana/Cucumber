import Pages.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class StepDefinitions {
    WebDriver driver;
    Login login;

    @Given("User visits HRM website")
    public void user_visits_hrm_website() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver.exe");
        FirefoxOptions ops = new FirefoxOptions();
        ops.addArguments("--headed"); //uncomment if you want to run in headless mode
        driver = new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/");

    }

    @When("User enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        login = new Login(driver);
        login.doLogin(username, password);
    }

    @Then("User can't log in")
    public void user_can_t_log_in() {
        // Write code here that turns the phrase above into concrete actions
        login = new Login(driver);
        String text = login.getErrorMsg();
        Assert.assertEquals("Invalid credentials", text);
        driver.close();
    }

}
