package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ChromeTest {
    @Test
    void openBrowserWithDefaultMode() {
        WebDriver driver = new ChromeDriver(); // open Chrome
        driver.get("https://www.selenium.dev/"); // automatically navigata to the link https
        Assert.assertEquals(driver.getTitle(), "Selenium"); // compare the title of web to text "Selenium"
        driver.quit(); // close the browser
    }

    @Test
    void openBrowserWithHeadlessMode() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void openBrowserWithMobileViewMode() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 344);
        deviceMetrics.put("height", 882);

        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }
}
