package ua.com.rozetka;

import com.google.core.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.com.rozetka.pages.RozetkaMainPage;
import ua.com.rozetka.pages.RozetkaResultPage;

public class RozetkaSearchTest extends WebDriverTestBase {

    @Test
    public void SearchAndAddItemTest(){
        String searchText = "iPhone 8";
        driver.get("https://rozetka.com.ua/");
        RozetkaMainPage mainPage = PageFactory.initElements(driver, RozetkaMainPage.class);
        mainPage.setDriver(driver);
        RozetkaResultPage resultPage = mainPage.searchForGood(searchText);
        Assert.assertTrue(resultPage.getGoods().get(0).getText().contains(searchText));
        resultPage.addGoodToBasket();
        //Assert.assertTrue(resultPage.getCartPopup().headerText().equals("Кошик"));
        Assert.assertTrue(resultPage.getCartPopup().getLinkOfLastAddedGood().getText().contains(searchText));
    }
}
