package ru.stqa.training.selenium.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends Page {
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public ProductPage addToCard() {
        driver.findElement(By.name("add_cart_product")).click();
        return this;
    }

    public ProductPage ensureItemsInCart(int number) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.quantity"), "" + number));
        return this;
    }

    public CheckoutPage checkout() {
        driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
        return new CheckoutPage(driver, wait);
    }
}
