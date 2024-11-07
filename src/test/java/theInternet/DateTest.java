package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

    public class DateTest {
        @Test
        void selectDate() {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");

            WebDriver driver = new ChromeDriver(chromeOptions);
            driver.get("https://www.vietnamairlines.com/vn/en/home");
            driver.manage().window().maximize();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("roundtrip-date-depart"))).click();

            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                    .get(0)
                    .findElements(By.tagName("td"))
                    .stream()
                    .filter(cell -> cell.getText().contains("30"))
                    .findFirst()
                    .ifPresent(WebElement::click);

            String departDate = driver.findElement(By.id("roundtrip-date-depart")).getAttribute("value");
            String returnDate = driver.findElement(By.id("roundtrip-date-return")).getAttribute("value");

            Assert.assertEquals(departDate, "30/11/2024");
        }
    }

