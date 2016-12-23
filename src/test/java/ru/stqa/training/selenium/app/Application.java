package ru.stqa.training.selenium.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class Application {
    private static WebDriver driver;
    private static WebDriverWait wait;
    public static MainPage mainPage;

    public Application() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);

        mainPage = new MainPage(driver, wait);
    }

    public void close() {
        driver.quit();
    }
}
