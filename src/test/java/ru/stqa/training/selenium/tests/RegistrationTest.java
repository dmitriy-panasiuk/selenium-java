package ru.stqa.training.selenium.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.stqa.training.selenium.BaseTest;

public class RegistrationTest extends BaseTest {

    private static String mainPageURL = "http://localhost/litecart/";

    @Before
    public void openMainPage() {
        driver.get(mainPageURL);
    }

    @Test
    public void registerNewUser() {
        String email = "a2@gmail.com";
        String password = "admin";

        driver.findElement(By.xpath(".//*[@id='box-account-login']/div/form/table/tbody/tr[5]/td/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("Dima");
        driver.findElement(By.name("lastname")).sendKeys("Panasiuk");
        driver.findElement(By.name("address1")).sendKeys("address1");
        driver.findElement(By.name("postcode")).sendKeys("04212");
        driver.findElement(By.name("city")).sendKeys("Kyiv");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("+380958350053");
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmed_password")).sendKeys(password);
        driver.findElement(By.name("create_account")).click();

        driver.findElement(By.xpath(".//*[@id='box-account']/div/ul/li[4]/a")).click();

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();

        driver.findElement(By.xpath(".//*[@id='box-account']/div/ul/li[4]/a")).click();
    }

}
