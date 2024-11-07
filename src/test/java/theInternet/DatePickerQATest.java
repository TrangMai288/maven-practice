package theInternet;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePickerQATest {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-practice.netlify.app/calendar");
    }

    @Test
    void enterDateIntoInputByJavascript() {
        WebElement element = driver.findElement(By.id("calendar"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='08/28/1999'", element);
    }
}
