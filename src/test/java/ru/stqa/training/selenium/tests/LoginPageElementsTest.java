package ru.stqa.training.selenium.tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.BaseTest;

public class LoginPageElementsTest extends BaseTest {

    private static String loginPageURL = "http://localhost/litecart/admin/";

    @BeforeClass
    public static void openLoginPage() {
        driver.get(loginPageURL);
    }

    @Test
    public void userNameFieldShouldBeVisible() {
        assertTrue(driver.findElement(By.name("username")).isDisplayed());
    }

    @Test
    public void passwordFieldShouldBeVisible() {
        assertTrue(driver.findElement(By.name("password")).isDisplayed());
    }

    @Test
    public void rememberMeCheckBoxShouldBeVisible() {
        assertTrue(driver.findElement(By.name("remember_me")).isDisplayed());
    }

    @Test
    public void rememberMeCheckBoxShouldBeUncheckedByDefault() {
        assertFalse(driver.findElement(By.name("remember_me")).isSelected());
    }

    @Test
    public void loginButtonShouldBeVisible() {
        assertTrue(driver.findElement(By.name("login")).isDisplayed());
    }
}
