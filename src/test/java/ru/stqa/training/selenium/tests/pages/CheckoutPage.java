package ru.stqa.training.selenium.tests.pages;

import org.apache.xpath.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CheckoutPage extends Page {
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public CheckoutPage clickRemoveButton() {
        driver.findElement(By.name("remove_cart_item")).click();
        return this;
    }

    public boolean productIsInCart(String name) {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(".//*[@id='order_confirmation-wrapper']//td[text()='" + name + "']"), 0));
            return true;//driver.findElements(By.xpath(".//*[@id='order_confirmation-wrapper']//td[text()='" + name + "']")).size() > 0 ;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean productIsNotInCart(String name) {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(".//*[@id='order_confirmation-wrapper']//td[text()='" + name + "']"), 0));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ExpectedCondition<Boolean> elementPresent(String xpath) {
        return driver -> {
            if (driver.findElements(By.xpath(xpath)).size() == 0) {
                return false;
            }
            return true;
        };
    }
}
