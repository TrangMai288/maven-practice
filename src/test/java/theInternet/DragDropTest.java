package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragDropTest {
    @Test
    void successfullyDragA2B() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);

        actions
                .dragAndDrop(driver.findElement(By.id("column-a")), driver.findElement(By.id("column-b")))
                .perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("#column-a header")).getText(), "B");
        Assert.assertEquals(driver.findElement(By.cssSelector("#column-b header")).getText(), "A");

        driver.quit();
    }
}
