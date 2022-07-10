package com.epam;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class WebDriverSeleniumHQTest {
    /**
     * Rigorous Test :-)
     */
    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
         driver = new ChromeDriver();

    }




    @Test(description = "Just first test, JIRA binding can be here")
    public void commonSearchTermResultsAreNotEmpty() {
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        // driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://hh.ru");
        //risky point here
        waitForElementLocated(driver, By.id("a11y-search-input"));

        //  WebElement searchInput = driver.findElement(By.id("a11y-search-input"));
        WebElement searchInput = waitForElementLocated(driver, By.id("a11y-search-input"));
        searchInput.sendKeys("java developer");
        /*WebElement searchBtn = driver.findElement(By.xpath("//*[@data-qa='search-button']"));
        searchBtn.click(); */
        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@data-qa='search-button']"));
        searchBtn.get(0).click();
       // Thread.sleep(1000);

        System.out.println(searchBtn);
        Assert.assertTrue(searchBtn.size()>0, "Search result are empty");

    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }



    private static WebElement waitForElementLocated(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
