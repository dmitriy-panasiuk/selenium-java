package ru.stqa.training.selenium.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends Page{
    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public MainPage open() {
        driver.get("http://localhost/litecart/");
        return this;
    }

    public ProductPage clickOnProduct(String name) {
        driver.findElement(By.xpath(".//a/div[text()='" + name + "']")).click();
        return new ProductPage(driver, wait);
    }
}
