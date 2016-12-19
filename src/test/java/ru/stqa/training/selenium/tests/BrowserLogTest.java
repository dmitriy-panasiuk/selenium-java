package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.BaseTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class BrowserLogTest extends BaseTest {

    private String catalogPageURL = "http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1";

    @Before
    public void openPage() {
        driver.get(catalogPageURL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void browserLogsShouldNotHaveEntries() {
        List<String> productLinks = driver.findElements(By.xpath("//td/a[contains(text(), 'Duck')][1]")).
                stream().map(el -> el.getAttribute("href")).collect(Collectors.toList());
        for (String productURL : productLinks) {
            driver.get(productURL);
            assertTrue(driver.manage().logs().get("browser").getAll().size() == 0);
        }
    }
}
