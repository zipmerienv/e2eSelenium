package BDD.com.equerest.steps;

import BDD.com.equerest.pages.RegisterPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EnterpreneurSteps {
    public static final String REGISTER_PAGE = "https://dev.equerest.com/register#/entrepreneur";

    private WebDriver webDriver;
    private RegisterPage registerPage;

    @Given("^I am on new project registration page")
    public void openRegisterPage() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.get(REGISTER_PAGE);
    }

    @When("^I fill my first name \"([^\"]*)\" and last name \"([^\"]*)\"")
    public void fillFirstAndLastName(String firstName, String lastName){
        registerPage = new RegisterPage(webDriver);
        registerPage.fillFIO(firstName, lastName);
    }
}
