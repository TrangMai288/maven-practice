package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    // cach 1
    @Test
    void dropDownTest1() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[@value='1']"));
        dropdown1.click();
        Assert.assertTrue(dropdown1.isSelected());
    }

    // cach 2
    @Test
    void dropdownTest2() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByValue("1");
        Assert.assertTrue(dropdown.getFirstSelectedOption().isSelected());
    }

    // cach 3
    @Test
    void dropdownTest3() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(1);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Option 1");
    }

    // cach 4
    @Test
    void dropdownTest4() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");
        Assert.assertEquals(dropdown.getOptions().get(1).getText(), "Option 1");
    }

    // multiple select
    @Test
    void ableSelectMultipleOptions() {
        driver.get("https://output.jsbin.com/osebed/2");

        Select selectMultiple = new Select(driver.findElement(By.id("fruits")));

        selectMultiple.selectByVisibleText("Banana");
        selectMultiple.selectByVisibleText("Apple");

        Assert.assertTrue(selectMultiple.isMultiple());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());

        selectMultiple.deselectByVisibleText("Banana");

        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());

        selectMultiple.deselectAll();

        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='fruits']/option[@value='grape']")).isSelected());
    }

    @AfterMethod
    void quit() {
        driver.quit();
    }
}
