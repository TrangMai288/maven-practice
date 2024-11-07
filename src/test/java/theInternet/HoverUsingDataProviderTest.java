package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class HoverUsingDataProviderTest {
    WebDriver driver;

    @DataProvider
    Object[][] testData() {
        return new Object[][]{
                {0, "name: user1"},
                {1, "name: user2"},
                {2, "name: user3"}
        };
    }

    @BeforeClass
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test(dataProvider = "testData")
    void ableToHoverImage(int index, String expectedResult) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElements(By.cssSelector("#content .figure")).get(index)).perform();

        String resultImage = driver.findElements(By.cssSelector(".figcaption h5")).get(index).getText();
        Assert.assertTrue(resultImage.contains(expectedResult));
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
