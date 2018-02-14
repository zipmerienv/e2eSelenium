package org.openenglish.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class OELoginPage extends AbstractPage{
    private WebElement loginTextBox;
    private By loginTextBoxLocator = By.id("username");

    private WebElement passwordTextbox;
    private By passwordTextBoxLocator = By.id("password");

    private WebElement submitButton;
    private By submitButtonLocator = By.id("login-btn");

    private WebElement closeButn;
    private By closeButnLocator = By.id("banner-title");

    private By MenuLocator = By.id("");

    public OELoginPage(WebDriver driver) {super(driver);}

    public void Login(String login, String passsword) {
        closeButn = driver.findElement(closeButnLocator);
        closeButn.click();

        loginTextBox = driver.findElement(loginTextBoxLocator);
        loginTextBox.sendKeys(login);

        passwordTextbox = webDriverUtil.waitFor(elementToBeClickable(passwordTextBoxLocator));
        passwordTextbox.sendKeys(passsword);

        submitButton = webDriverUtil.waitFor(elementToBeClickable(submitButtonLocator));
        submitButton.click();

        Actions action = new Actions(driver);
        WebElement menu = driver.findElement(MenuLocator);
        action.moveToElement(menu).build().perform();
    }
}

