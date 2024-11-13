package theInternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class CaptureScreenShotTest {
    @Test
    void captureScreenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("target/selenium.png");
        FileUtils.copyFile(scrFile, destFile);
    }

    @Test
    void captureScreenshotUsingTime() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();

        long index = System.currentTimeMillis();
        String destinationFile = String.format("target/selenium%d.png", index);

        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(destinationFile);
        FileUtils.copyFile(scrFile, destFile);
    }
}
