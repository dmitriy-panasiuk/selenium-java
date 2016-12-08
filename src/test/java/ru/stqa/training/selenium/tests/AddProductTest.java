package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.BaseTest;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class AddProductTest extends BaseTest {

    private static String loginPageURL = "http://localhost/litecart/admin/";

    @Before
    public void login() {
        driver.get(loginPageURL);
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void addProductTest () {
        String name = "test product1";

        wait.until(elementToBeClickable(By.xpath(".//*[@id='box-apps-menu-wrapper']/ul/li[2]/a")));
        driver.findElement(By.xpath(".//*[@id='box-apps-menu-wrapper']/ul/li[2]/a")).click();
        wait.until(elementToBeClickable(By.xpath(".//*[@id='content']/div[1]/a[2]")));
        driver.findElement(By.xpath(".//*[@id='content']/div[1]/a[2]")).click();
        wait.until(elementToBeClickable(By.xpath(".//*[@id='tab-general']/table/tbody/tr[1]/td/label[1]/input")));
        driver.findElement(By.xpath(".//*[@id='tab-general']/table/tbody/tr[1]/td/label[1]/input")).click();
        driver.findElement(By.name("name[en]")).sendKeys(name);
        driver.findElement(By.name("code")).sendKeys("04212");
        driver.findElement(By.xpath(".//*[@id='tab-general']/table/tbody/tr[4]/td/div/table/tbody/tr[2]/td[1]/input")).click();
        driver.findElement(By.xpath(".//*[@id='tab-general']/table/tbody/tr[7]/td/div/table/tbody/tr[4]/td[1]/input")).click();
        driver.findElement(By.name("date_valid_from")).sendKeys("2016-12-01");
        driver.findElement(By.name("date_valid_to")).sendKeys("2017-12-01");


        driver.findElement(By.xpath(".//*[@id='content']/form/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath(".//*[@id='tab-information']/table/tbody/tr[1]/td/select/option[2]")).click();
        driver.findElement(By.name("keywords")).sendKeys(name);
        driver.findElement(By.name("short_description[en]")).sendKeys(name);
        driver.findElement(By.xpath(".//*[@id='tab-information']/table/tbody/tr[5]/td/span/div/div[2]")).sendKeys(name);
        driver.findElement(By.name("head_title[en]")).sendKeys(name);
        driver.findElement(By.name("meta_description[en]")).sendKeys(name);



        driver.findElement(By.xpath(".//*[@id='content']/form/div/ul/li[4]/a")).click();
        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("1");
        driver.findElement(By.xpath(".//*[@id='tab-prices']/table[1]/tbody/tr/td/select/option[2]")).click();
        driver.findElement(By.name("prices[USD]")).sendKeys("1");
        driver.findElement(By.name("prices[EUR]")).sendKeys("1");

        driver.findElement(By.name("save")).click();

        assertTrue(driver.findElements(By.linkText(name)).size() > 0);
    }
}
