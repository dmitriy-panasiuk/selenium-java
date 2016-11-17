package ru.stqa.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class FirstTest extends BaseTest {

    @Test
    public void myFirstTest() {
        driver.get("http://google.com/");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }
}
