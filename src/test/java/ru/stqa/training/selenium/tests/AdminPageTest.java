package ru.stqa.training.selenium.tests;

import org.apache.xpath.SourceTree;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.BaseTest;

import java.util.List;

public class AdminPageTest extends BaseTest {

    private static String loginPageURL = "http://localhost/litecart/admin/";

    @BeforeClass
    public static void openLoginPage() {
        driver.get(loginPageURL);
    }

    @Test
    public void browseAdminPage() throws InterruptedException {
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int size = driver.findElements(By.cssSelector("#box-apps-menu > li")).size();
        for (int index = 1; index <= size; index++) {
            String itemCss = "#box-apps-menu > li:nth-child(" + index + ")";
            WebElement menuItem = driver.findElement(By.cssSelector(itemCss));
            System.out.println("clicking on " + menuItem.getText() + " menu item");
            menuItem.click();
            int subSize = driver.findElements(By.cssSelector(itemCss + " > ul > li")).size();
            for (int subIndex = 1; subIndex <= subSize; subIndex++) {
                WebElement subMenuItem = driver.findElement(By.cssSelector(itemCss + "> ul > li:nth-child(" + subIndex + ")"));
                System.out.println("clicking on " + subMenuItem.getText() + " sub menu item");
                subMenuItem.click();
            }
        }
    }
}
