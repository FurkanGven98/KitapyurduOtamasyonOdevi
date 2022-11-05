package org.example.methods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.driver.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Methods {
    private static Logger logger= LogManager.getLogger(Methods.class);
    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsDriver;

    public Methods(){
        driver = BaseTest.webDriver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
        jsDriver=(JavascriptExecutor) driver;
    }
    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void Click(By by) {
        findElement(by).click();
        logger.info(by + "Elementi tıklandı");
    }
    public void waitBySecond(long seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(seconds + "saniye beklendi");
    }
    public void sendKeys(By by,String text){
        findElement(by).sendKeys(text);
        logger.info(text + " keyi gönderildi.");
    }
    public boolean isElementVisible(By by){
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void scrollWithAction(By by){
        Actions actions=new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }
    public Select getSelect(By by){
        return new Select(findElement(by));
    }
    public void SelectByText(By by,String text){
        getSelect(by).selectByVisibleText(text);
    }
    public void randomClick(By by){
        List<WebElement> links=driver.findElements(by);
        WebElement random=links.get(new Random().nextInt(links.size()));
        random.click();
    }
    public void textKontrol(String text){
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue("Text not found!", bodyText.contains(text));
        logger.info("Text: " +text);
    }
        public void randomClickFourTimes (By by){

            for(int i=0;i<4;i++){
                List<WebElement> links = driver.findElements(by);
        WebElement random = links.get(new Random().nextInt(links.size()-2)+2);
        random.click();
    }
    }
    public void hoverElement(By by){
        Actions actions=new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();
    }


}
