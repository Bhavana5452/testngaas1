package com.activity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class AppTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Change the path to the chromedriver executable based on your local machine's location
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLinkCountAndUrls() {
        driver.get("https://www.flipkart.com/");
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links: " + links.size());
        for (int i = 0; i < links.size(); i++) {
            String linkText = links.get(i).getText();
            String linkUrl = links.get(i).getAttribute("href");
            System.out.println((i+1) + ". Link Text: " + linkText + " - URL: " + linkUrl);
        }
        Assert.assertTrue(links.size() > 0);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}