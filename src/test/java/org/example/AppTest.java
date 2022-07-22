package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import java.util.List;

import static org.testng.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void ICanWin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Selenium-Drivers\\chromedriver.exe");
//        WebDriverManager
 //       WebDriverManager.chromedriver.setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pastebin.com/");

        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        WebElement newpaste = driver.findElement(By.name("PostForm[text]"));
        newpaste.sendKeys("Hello from WebDriver");
        Thread.sleep(2000);
        driver.findElement(By.id("postform-name")).sendKeys("helloweb");

        driver.findElement(By.id("select2-postform-status-container"));

        WebElement elem = driver.findElement(By.id("select2-postform-expiration-container"));

        new WebDriverWait(driver,Duration.ofMillis(5000)).until(ExpectedConditions.elementToBeClickable(elem)).click();

       driver.findElement(By.xpath("//span[@class='select2-results']/ul/li[3]")).click();

       /* Select select = new Select(driver.findElement(By.id("postform-expiration")));

        select.selectByVisibleText("10 Minutes");*/
     /*   List<WebElement> list=select.getOptions();
        for(WebElement element:list){
            System.out.println(element.getText());
        }*/


        //WebElement searchBox = driver.findElement(By.cssSelector("q"));
        //WebElement searchButton = driver.findElement(By.name("btnK"));
        //searchButton.click();
//        driver.quit();
    }
}
