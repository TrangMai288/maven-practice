package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HorizontalSliderTest {
    @Test
    void ableToHorizontalSlidePointer() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions actions = new Actions(driver);
        WebElement pointer = driver.findElement(By.cssSelector(".sliderContainer input"));
        int offSetWidth = pointer.getSize().getWidth();
        int offSetHeight = pointer.getSize().getHeight();
        System.out.printf("%d %d", offSetHeight, offSetWidth);

        actions.clickAndHold(pointer)
                .moveByOffset(offSetWidth,0)
                .perform();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("range"), "5")));

    }
}
