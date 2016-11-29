package ru.stqa.training.selenium.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SortZonesTest extends BaseTest {

    private static String zonesPageURL = "http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones";

    @BeforeClass
    public static void openLoginPage() {
        driver.get(zonesPageURL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void zonesShouldBeInAlphabeticalOrder() {
        List<WebElement> linksToCountryPage = driver.findElements(By.xpath(".//*[@id='content']/form/table/tbody/tr/td[5]/a"));

        List<String> urls = linksToCountryPage.stream().
                map(s -> s.getAttribute("href")).collect(Collectors.toList());

        for (String url : urls) {
            driver.get(url);
            List<WebElement> zones = driver.findElements(By.xpath(".//*[@id='table-zones']/tbody/tr/td[3]/select/option[@selected='selected']"));
            assertTrue("zones are not sorted", countriesSorted(zones));
        }
    }
}
