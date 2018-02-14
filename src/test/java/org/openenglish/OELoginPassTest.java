package org.openenglish;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class OELoginPassTest {
    private WebDriver driver;

    private WebElement loginTextBox;
    private By loginTextBoxLocator = By.id("username");

    private WebElement passwordTextbox;
    private By passwordTextBoxLocator = By.id("password");

    private WebElement submitButton;
    private By submitButtonLocator = By.id("login-btn");

    private WebElement closeButn;
    private By closeButnLocator = By.id("banner-title");

    private By MenuLocator = By.id("");


    @BeforeClass (enabled = false)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void LoginTest(){
        driver.get("https://learningplatform.stg.openenglish.com/login");
        closeButn = driver.findElement(closeButnLocator);
        closeButn.click();

        loginTextBox = driver.findElement(loginTextBoxLocator);
        loginTextBox.sendKeys("shiosaky@gmail.com.oe");

        passwordTextbox = driver.findElement(passwordTextBoxLocator);
        passwordTextbox.sendKeys("123456");

        submitButton = driver.findElement(submitButtonLocator);
        submitButton.click();

        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(MenuLocator);
        action.moveToElement(menu).build().perform();


        assertEquals("David", driver.findElement(By.xpath("")).getText());
    }
}

