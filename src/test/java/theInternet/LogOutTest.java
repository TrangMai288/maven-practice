package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest {
    WebDriver driver;
    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test (timeOut = 10000, description = "test logout ")
    void logoutSuccessfully() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        driver.findElement(By.cssSelector("i.icon-signout")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged out of the secure area!"));
        driver.quit();
    }
}
