package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HoverTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    void ableToHoverImage1() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(By.cssSelector("#content .figure")).get(0)).perform();

        String resultImage = driver.findElements(By.cssSelector(".figcaption >h5")).get(0).getText();
        Assert.assertTrue(resultImage.contains("name: user1"));
    }

    @Test
    void ableToHoverImage2() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(By.cssSelector("#content .figure")).get(1)).perform();

        String resultImage = driver.findElements(By.cssSelector(".figcaption >h5")).get(1).getText();
        Assert.assertTrue(resultImage.contains("name: user2"));
    }

    @Test
    void ableToHoverImage3() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(By.cssSelector("#content .figure")).get(2)).perform();

        String imageName = driver.findElements(By.cssSelector(".figcaption h5")).get(2).getText();
        Assert.assertTrue(imageName.contains("name: user3"));
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
