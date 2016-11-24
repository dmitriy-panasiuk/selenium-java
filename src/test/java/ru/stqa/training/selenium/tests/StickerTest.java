package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.BaseTest;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class StickerTest extends BaseTest {

    private static String homePageURL = "http://localhost/litecart/";

    @Before
    public void openHomePage() {
        driver.get(homePageURL);
    }

    @Test
    public void stickerTest() {
        List<WebElement> boxes = driver.findElements(By.cssSelector("div.middle > div.content > div.box"));
        for (WebElement currentBox : boxes) {
            List<WebElement> products = currentBox.findElements(By.cssSelector("li.product"));
            for (WebElement product1 : products) {
                assertEquals(1, product1.findElements(By.cssSelector("div.sticker")).size());
            }
        }
    }
}
