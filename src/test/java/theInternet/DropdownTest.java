package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropdownTest {
    /**
     *
     1. Open browser
     2. Navigate to https://the-internet.herokuapp.com/dropdown
     3. Select "option 1"
     4. Validate "option 1" is selected
     */
    WebDriver driver;
    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void dropDown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // cach 1
        WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[contains(.,'Option 1')]"));
        dropdown1.click();
        Assert.assertTrue(dropdown1.isSelected());

        // cach 2
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(1);
        Assert.assertTrue(dropdown1.isSelected());

        // cach 3
        dropdown.selectByValue("1");
        Assert.assertTrue(dropdown1.isSelected());

        // cach 4
        dropdown.selectByVisibleText("Option 1");
        Assert.assertTrue(dropdown1.isSelected());
    }
}
