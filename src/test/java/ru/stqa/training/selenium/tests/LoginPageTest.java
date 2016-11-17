package ru.stqa.training.selenium.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.BaseTest;

public class LoginPageTest extends BaseTest {

    private static String loginPageURL = "http://localhost/litecart/admin/";
    private static String logoutPageURL = "http://localhost/litecart/admin/logout.php";

    @Before
    public void openLoginPage() {
        driver.get(loginPageURL);
    }

    @Test
    public void errorIsGivenForInvalidUsername() {
        driver.findElement(By.name("username")).sendKeys("admin1");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        assertEquals("The user could not be found in our database", driver.findElement(By.id("notices-wrapper")).getText());
    }

    @Test
    public void successfulLogin() {
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        assertEquals("Appearence", driver.findElement(By.id("app-")).getText());
    }

    @After
    public void logout() {
        driver.get(logoutPageURL);
    }
}
