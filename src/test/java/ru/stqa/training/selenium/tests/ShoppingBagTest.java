package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.training.selenium.BaseTest;

public class ShoppingBagTest extends BaseTest{
    private static String productPageURL = "http://localhost/litecart/en/rubber-ducks-c-1/subcategory-c-2/green-duck-p-2";

    @Test
    public void shoppingBagTest() {
        for (int i = 1; i <= 3; i++) {
            driver.get(productPageURL);
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("span.quantity"), "" + i));
        }
        driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
        WebElement product = driver.findElement(By.xpath(".//*[@id='order_confirmation-wrapper']/table/tbody/tr[2]"));
        driver.findElement(By.name("remove_cart_item")).click();
        wait.until(ExpectedConditions.stalenessOf(product));
    }
}
