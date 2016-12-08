package ru.stqa.training.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeClass
    public static void start() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    protected boolean countriesSorted(List<WebElement> countries) {
        String prevCountryText = countries.get(0).getText();
        for (int i = 1; i < countries.size(); i++) {
            String currentCountryText = countries.get(i).getText();
            if (currentCountryText.compareTo(prevCountryText) < 0) {
                return false;
            }
            prevCountryText = currentCountryText;
        }

        return true;
    }

    @AfterClass
    public static void stop() {
        driver.quit();
    }
}
