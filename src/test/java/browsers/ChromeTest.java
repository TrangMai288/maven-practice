package browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v129.emulation.Emulation;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.ConnectionType;
import org.openqa.selenium.devtools.v129.performance.Performance;
import org.openqa.selenium.devtools.v129.performance.model.Metric;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @Test
    void openBrowserWithOldVersion() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("125");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void openBrowserWithBetaVersion() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("131.0.6752.0"); // beta version: 131.0.6752.0

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void openBrowserWithFakeGeolocation() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.386052),
                Optional.of(-122.083851),
                Optional.of(1)
        ));
        driver.get("https://the-internet.herokuapp.com/geolocation");
        driver.findElement(By.xpath("//button[.='Where am I?']")).click();

        // using xpath
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='lat-value']")).getText(), "37.386052");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id='long-value']")).getText(), "-122.083851");

        // using cssSelector
         Assert.assertEquals(driver.findElement(By.cssSelector("#lat-value")).getText(), "37.386052");
         Assert.assertEquals(driver.findElement(By.cssSelector("#long-value")).getText(), "-122.083851");

    }

    @Test
    void interceptionNetwork() {
        WebDriver driver = new ChromeDriver();
        DevTools devTool = ((HasDevTools) driver).getDevTools();

        devTool.createSession();
        devTool.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        devTool.addListener(Network.requestWillBeSent(), requestSend -> {
            System.out.println("Request URL => " + requestSend.getRequest().getUrl());
            System.out.println("Request Method => " + requestSend.getRequest().getMethod());
            System.out.println("Request Header => " + requestSend.getRequest().getHeaders());
            System.out.println("--------------------------------------");
        });

        devTool.addListener(Network.responseReceived(), responseReceived -> {
            System.out.println("Response Url => " + responseReceived.getResponse().getUrl());
            System.out.println("Response Status => " + responseReceived.getResponse().getStatus());
            System.out.println("Response Headers => " + responseReceived.getResponse().getHeaders());
            System.out.println("Response MIME Type => " + responseReceived.getResponse().getMimeType().toString());
            System.out.println("--------------------------------------");
        });

        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void openSeleniumHomePageAndCapturePerformanceMetrics() {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();

        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metricList = devTools.send(Performance.getMetrics());
        driver.get("https://www.selenium.dev/");

        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();

        for (Metric m : metricList) {
            System.out.println(m.getName() + " = " + m.getValue());
        }
    }

    @Test
    void simulate3GNetworkCondition() {
        ChromeDriver driver = new ChromeDriver();
        DevTools devTools = driver.getDevTools();
        devTools.createSession();

        // Enable Network emulation
        devTools.send(Network.enable(
                Optional.of(100000000),
                Optional.empty(),
                Optional.empty()));

        // Set network conditions to emulate 3G or 4G
        devTools.send(Network.emulateNetworkConditions(
                false,
                100,
                75000,
                25000,
                Optional.of(ConnectionType.CELLULAR3G),
                Optional.of(0),
                Optional.of(0),
                Optional.of(false)
        ));
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    /*
        1. Nhap username
        2. Nhap password
        3. Click Login
        4. Kiem tra ket qua
     */
    @Test
    void testXpath() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//button[@class='radius']//child::i[contains(text(), 'Login')]")).click();
        Assert.assertEquals(driver.findElement(
                By.xpath("//h4[@class='subheader']")).getText(),
                "Welcome to the Secure Area. When you are done click logout below.");
    }
}
