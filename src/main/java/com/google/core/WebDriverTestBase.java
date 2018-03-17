package com.google.core;

import com.google.util.ScreenShotOnFailListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners(ScreenShotOnFailListener.class)
public class WebDriverTestBase {

    public WebDriver driver;
    protected BrowsersEnum browser = BrowsersEnum.valueOf(System.getProperty("browser", "CHROME"));
    private DesiredCapabilities setDesiredCapabilities(String platform, String remoteBrowser) throws MalformedURLException {

        //DesiredCapabilities caps = DesiredCapabilities.chrome();
        //caps.setCapability("platform", "macOS 10.13");
        //caps.setCapability("version", "64.0");


        DesiredCapabilities caps = new DesiredCapabilities();
        if (platform.equalsIgnoreCase( Platform.MAC.name())) {
            caps.setPlatform(Platform.MAC);
            caps.setBrowserName(remoteBrowser);
        }
        return caps;
    }
    @Parameters({"platform", "remoteBrowser"})
    @BeforeClass
    public void SetUp(@Optional String platform, @Optional String remoteBrowser) throws MalformedURLException {
        switch (browser) {
            case CHROME:
                //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
                WebDriverManager.chromedriver().setup();  //with latest version of driver
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                //WebDriverManager.chromedriver().version("2.35").setup(); //with specified version of driver
                WebDriverManager.firefoxdriver().setup();  //with latest version of driver
                driver = new FirefoxDriver();
                break;

            case REMOTE:
                DesiredCapabilities caps = setDesiredCapabilities(platform, remoteBrowser);
                driver = new RemoteWebDriver(new URL("http://192.168.88.102:4444/wd/hub"), caps);
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //timeout for page load
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS); //timeout for load scripts
    }

    @AfterClass
    public void tearDown() {
        //driver.close(); //current tab
        driver.quit(); //close at all

    }
}
