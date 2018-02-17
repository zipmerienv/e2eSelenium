package com.google.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage {

    private WebDriver driver;
    private By searchFieldLocator = By.name("q");
    private WebElement searchField;

    private By searchButtonLocator = By.xpath("//*[@id=\"sbtc\"]/div[2]/div[2]/div[1]/div/ul/li[11]/div/span[1]/span/input");
    private WebElement searchButton;

    public GoogleSearchPage(WebDriver driver){
        this.driver = driver;
    }

    @Step("Search for {0}")
    public void searchFor(String searchData){
        searchField = driver.findElement(searchFieldLocator);
        searchField.sendKeys(searchData);
        searchField.submit();
    }


}
