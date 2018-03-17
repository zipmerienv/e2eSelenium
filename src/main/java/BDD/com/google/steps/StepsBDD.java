package BDD.com.google.steps;

import com.google.pages.GoogleSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepsBDD {
    public static final String GOOGLE_PAGE = "https://www.google.com.ua/";

    private WebDriver webDriver;
    private GoogleSearchPage googleSearchPage;

    @Given("^I am on google search page")
    public void openRegisterPage() {
        ChromeDriverManager.getInstance().setup();
        webDriver = new ChromeDriver();
        webDriver.get(GOOGLE_PAGE);
    }

    @When("^I fill search field \"([^\"]*)\"")
    public void fillSearchField(String searchData){
        googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.searchFor(searchData);
    }

}