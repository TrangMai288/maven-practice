package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest {
    /**
     * 1. Open browser
     * 2. Navigate to https://the-internet.herokuapp.com/checkboxes
     * 3. Check on checkbox1
     * 4. Verify checkbox1 is checked
     * 5. Check on checkbox2
     * 6. Verify checkbox2 is checked
     */

    @Test
    void checkboxes() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // cach 1
        driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).isSelected());

        // cach 2
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected());

        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected());

        // cach 3
        check(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());

        check(checkbox2);
        Assert.assertTrue(checkbox2.isSelected());

        driver.quit();
    }

    public static void check(WebElement checkbox) {
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public static void uncheck(WebElement checkbox) {
        if (checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
