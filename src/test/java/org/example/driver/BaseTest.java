package org.example.driver;

import org.example.pages.ProductPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public static WebDriver webDriver=null;

    @Before
    public void setUp(){
    System.setProperty("webdriver.chrome.driver","C:\\Users\\testinium\\IdeaProjects\\KitapyurduOtamasyonOdevi\\src\\test\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-notifications");
        options.addArguments("disable-popup-blocking");

        setWebDriver(new ChromeDriver(options));
        getWebDriver().navigate().to("https://www.kitapyurdu.com/");
    }
    public static WebDriver getWebDriver(){
        return webDriver;
    }
    public static void setWebDriver(WebDriver webDriver){
        BaseTest.webDriver=webDriver;
    }
    @After
    public void tearDown(){
        if(webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
