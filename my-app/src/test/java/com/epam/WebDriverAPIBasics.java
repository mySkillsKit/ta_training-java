package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class WebDriverAPIBasics {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://hh.ru");
        WebElement searchInput = driver.findElement(By.id("a11y-search-input"));
        searchInput.sendKeys("java developer");
        /*WebElement searchBtn = driver.findElement(By.xpath("//*[@data-qa='search-button']"));
        searchBtn.click(); */
        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@data-qa='search-button']"));
        searchBtn.get(0).click();
        Thread.sleep(1000);
        driver.quit();

    }

}
