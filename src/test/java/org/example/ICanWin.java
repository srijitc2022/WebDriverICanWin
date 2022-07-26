package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
public class ICanWin {
    WebDriver driver;
    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        //driver.close();
        driver.quit();
    }
    @Test
    public void ICanWinTest() throws InterruptedException {
        /* 1. Open https://pastebin.com/ or a similar service in any browser. */
        driver.get("https://pastebin.com/");


        /* 2(i) Code: "Hello from WebDriver" */
        WebElement newPaste = driver.findElement(By.name("PostForm[text]"));
        newPaste.sendKeys("Hello from WebDriver");
        Thread.sleep(2000);


        /* 2(ii) Paste Expiration: "10 Minutes" */
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)", "");
        WebElement elem = driver.findElement(By.id("select2-postform-expiration-container"));
        Thread.sleep(2000);


        /* 2(iii) Paste Name / Title: "helloweb" */
        new WebDriverWait(driver,Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(elem)).click();
        driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[3]")).click();
        driver.findElement(By.id("postform-name")).sendKeys("helloweb");


        /* 2 (iv) Finally, Click 'New Paste' button to create New paste. */
        WebElement btnCreate = driver.findElement(By.xpath("//button[text()='Create New Paste']"));
        Thread.sleep(2000);
        new WebDriverWait(driver,Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(btnCreate)).click();

    }
}
