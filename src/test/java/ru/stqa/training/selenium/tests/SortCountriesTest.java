package ru.stqa.training.selenium.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SortCountriesTest extends BaseTest {

    private static String countriesPageURL = "http://localhost/litecart/admin/?app=countries&doc=countries";

    @BeforeClass
    public static void openLoginPage() {
        driver.get(countriesPageURL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void countriesShouldBeInAlphabeticalOrder() {
        List<WebElement> countries = driver.findElements(By.cssSelector("tr.row > td:nth-child(5)"));
        assertTrue("countries are not sorted", countriesSorted(countries));
    }

    @Test
    public void geoZonesShouldBeInAlphabeticalOrder() {
        List<WebElement> countriesWithZones = driver.findElements(By.xpath(".//tbody/tr/td[6][not(text() = '0')]/../td[7]/a"));
        List<String> urls = countriesWithZones.stream().
                map(country -> country.getAttribute("href")).collect(Collectors.toList());

        for (String url : urls) {
            driver.get(url);
            List<WebElement> zones = driver.findElements(By.xpath(".//*[@id='table-zones']/tbody/tr[not(@class='header') and position() < last()]/td[3]"));
            assertTrue("zones are not sorted", countriesSorted(zones));
        }
    }
}
