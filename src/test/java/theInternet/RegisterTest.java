package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://bookcart.azurewebsites.net/register");
    }

    @Test
    void registerSuccessfully() {
        long index = System.currentTimeMillis();
        String firstname = String.format("firstname%d", index);
        String lastname = String.format("lastname%d", index);
        String username = String.format("username%d", index);
        String password = String.format("Test123456@");
        String confirmPassword = String.format("Test123456@");

        driver.findElement(By.xpath("//input[@formcontrolname='firstname']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@formcontrolname='lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmPassword);

        driver.findElement(By.xpath("//input[@value='Male']")).click();

        driver.findElement(By.xpath("//span[text()='Register']/ancestor::button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://bookcart.azurewebsites.net/login");
        driver.quit();
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
