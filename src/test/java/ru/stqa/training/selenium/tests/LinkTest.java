package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import ru.stqa.training.selenium.BaseTest;

import java.util.List;
import java.util.Set;

public class LinkTest extends BaseTest {

    private static String countryPageURL = "http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=AF";

    @Before
    public void openCountryPage() {
        driver.get(countryPageURL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void openLinksTest() {
        List<WebElement> links = driver.findElements(By.xpath(".//*[@target='_blank']"));
        String mainWindowHandle = driver.getWindowHandle();
        for (WebElement link : links) {
            Set<String> windows = driver.getWindowHandles();
            link.click();
            String newWindow = wait.until(thereIsWindowOtherThan(windows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindowHandle);
        }
    }


    public static ExpectedCondition<String> thereIsWindowOtherThan(final Set<String> windows) {
        return driver -> {
            Set<String> currentWindows = driver.getWindowHandles();
            for (String window : currentWindows) {
                if (!windows.contains(window)) {
                    return window;
                }
            }
            return null;
        };
    }
}
