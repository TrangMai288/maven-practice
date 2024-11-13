package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormAuthenticationFirstVersionTest {
    /**
     1. Open browser
     2. Navigate to https://the-internet.herokuapp.com/login
     3. Fill in username with tomsmith
     4. Fill in the password with SuperSecretPassword!
     5. Click on Login button
     6. And the home page is appear
     */
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void shouldBeSuccessfullyWithValidCredentials() {
        driver.get("https://the-internet.herokuapp.com/login");
        // tagName + attributes + text()
        // example for "username"
        // 1. tagName
        driver.findElement(By.tagName("input")).sendKeys("tomsmith");

        // 2. attributes
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("tomsmith");

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith");

        driver.findElement(By.id("username")).sendKeys("tomsmith"); // best choices
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tomsmith");

        // 3. text(): n/a

        // password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // click button
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // verify current url = https://the-internet.herokuapp.com/secure
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");

        // verify message You logged into a secure area!
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area!"));
    }

    @Test
    void loginFailWhenEnteringWrongUsername(){
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tom");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector("button[type=submit]")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your username is invalid!"));
    }

    @Test
    void loginFailWhenEnteringWrongPassword() {
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("Super");
        driver.findElement(By.cssSelector("button[type=submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
        Assert.assertTrue(driver.findElement(By.className("error")).getText().contains("Your password is invalid!"));
    }

    @AfterMethod
    void quit() {
        driver.quit();
    }
}