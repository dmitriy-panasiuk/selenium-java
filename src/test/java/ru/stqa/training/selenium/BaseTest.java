package ru.stqa.training.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.app.Application;

import java.util.List;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Application app;

    @BeforeClass
    public static void start() {
        app = new Application();
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
        app.close();
    }
}
