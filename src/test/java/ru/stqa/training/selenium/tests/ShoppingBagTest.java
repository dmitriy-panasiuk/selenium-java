package ru.stqa.training.selenium.tests;

import org.junit.Test;
import ru.stqa.training.selenium.BaseTest;
import ru.stqa.training.selenium.tests.pages.CheckoutPage;
import ru.stqa.training.selenium.tests.pages.ProductPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShoppingBagTest extends BaseTest{
    private static String productName = "Green Duck";

    @Test
    public void shoppingBagTest() {
        ProductPage productpage = app.mainPage.open().clickOnProduct(productName);
        for (int i = 1; i <= 3; i++) {
            productpage.addToCard();
            productpage.ensureItemsInCart(i);
        }
        CheckoutPage checkoutPage = productpage.checkout();
        assertTrue(checkoutPage.productIsInCart(productName));
        checkoutPage.clickRemoveButton();
        assertTrue(checkoutPage.productIsNotInCart(productName));
    }


}
