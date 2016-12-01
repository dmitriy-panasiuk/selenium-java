package ru.stqa.training.selenium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.BaseTest;

public class ProductTest extends BaseTest {

    private static String homePageURL = "http://localhost/litecart/";

    @Before
    public void openLoginPage() {
        driver.get(homePageURL);
    }

    @Test
    public void productTest() {
        WebElement firstProductInCampaigns = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
        String productTitle = firstProductInCampaigns.findElement(By.cssSelector("div.name")).getText();
        String originalPrice = firstProductInCampaigns.findElement(By.cssSelector("s.regular-price")).getText();
        String salePrice = firstProductInCampaigns.findElement(By.cssSelector("strong.campaign-price")).getText();


        firstProductInCampaigns.click();
        assertEquals("Title is not the same", driver.findElement(By.cssSelector("div#box-product h1")).getText(), productTitle);
        assertEquals("Original price does not match",driver.findElement(By.cssSelector("s.regular-price")).getText(), originalPrice);
        assertEquals("Sale price does not match", driver.findElement(By.cssSelector("strong.campaign-price")).getText(), salePrice);
    }

    @Test
    public void originalPriceMainPageStyleTest() {
        WebElement firstProductInCampaigns = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
        String originalPriceTagName = firstProductInCampaigns.findElement(By.cssSelector("s.regular-price")).getTagName();
        String originalPriceStyle = firstProductInCampaigns.findElement(By.cssSelector("s.regular-price")).getAttribute("className");

        assertEquals("s", originalPriceTagName);
        assertTrue(originalPriceStyle.contains("regular-price"));
    }

    @Test
    public void originalPriceProductPageStyleTest() {
        WebElement firstProductInCampaigns = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
        firstProductInCampaigns.click();
        String originalPriceTagName = driver.findElement(By.cssSelector("s.regular-price")).getTagName();
        String originalPriceStyle = driver.findElement(By.cssSelector("s.regular-price")).getAttribute("className");

        assertEquals("s", originalPriceTagName);
        assertTrue(originalPriceStyle.contains("regular-price"));
    }

    @Test
    public void campaignPriceMainPageStyleTest() {
        WebElement firstProductInCampaigns = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
        String originalPriceTagName = firstProductInCampaigns.findElement(By.cssSelector("strong.campaign-price")).getTagName();
        String originalPriceStyle = firstProductInCampaigns.findElement(By.cssSelector("strong.campaign-price")).getAttribute("className");

        assertEquals("strong", originalPriceTagName);
        assertTrue(originalPriceStyle.contains("campaign-price"));
    }

    @Test
    public void campaignPriceProductPageStyleTest() {
        WebElement firstProductInCampaigns = driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li"));
        firstProductInCampaigns.click();
        String originalPriceTagName = driver.findElement(By.cssSelector("strong.campaign-price")).getTagName();
        String originalPriceStyle = driver.findElement(By.cssSelector("strong.campaign-price")).getAttribute("className");

        assertEquals("strong", originalPriceTagName);
        assertTrue(originalPriceStyle.contains("campaign-price"));
    }
}
