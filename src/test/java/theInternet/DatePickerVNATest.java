package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DatePickerVNATest {
    @Test
    void ableSelectDateForFlight() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.vietnamairlines.com/vn/en/home");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cookie-agree"))).click();

        //select city
        wait.until(ExpectedConditions.elementToBeClickable(By.id("city-to-roundtrip"))).click();

        wait
                .until(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(
                                By.cssSelector("#to-bookYourTripTo-vietnam div"))
                )
                .stream()
                .filter(row ->row.getText().contains("Hanoi (HAN), Vietnam"))
                .findFirst()
                .ifPresent(WebElement::click);


        // select depart date
        WebElement dateWidgetFrom = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#byt-datespicker .ui-datepicker-calendar"))).get(0);

        List<WebElement> dateCells = dateWidgetFrom.findElements(By.tagName("td"));
        dateCells.stream()
                .filter(element -> element.getText().contains("26"))
                .findFirst()
                .ifPresent(WebElement::click);

        // select return date
        wait.until(
                        ExpectedConditions
                                .visibilityOfAllElementsLocatedBy(
                                        By.cssSelector("#byt-datespicker .ui-datepicker-calendar")))
                .get(0)
                .findElements(By.tagName("td"))
                .stream()
                .filter(cell -> cell.getText().contains("31"))
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
