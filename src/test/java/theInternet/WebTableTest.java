package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebTableTest {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        driver = new ChromeDriver(chromeOptions);
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    void tc05() {
        double[] dueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(due -> Double.parseDouble(due.getText().replace("$", "")))
                .toArray();
        double maxDueValue = driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
                .stream()
                .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
                .max()
                .getAsDouble();

        int indexOfMaxDue = 0;
        for (int i = 0; i < dueValue.length; i++) {
            if (dueValue[i] == maxDueValue) {
                indexOfMaxDue = i + 1;
            }
        }

        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        String firstName = driver.findElement(By.xpath(String.format(cellLocator, indexOfMaxDue, 2))).getText();
        String lastName = driver.findElement(By.xpath(String.format(cellLocator, indexOfMaxDue, 1))).getText();

        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");
    }

    @Test
    void tc05UsingObject() {
        List<Person> table1Person = new ArrayList<>();
        String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";
        int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

        for (int i = 1; i <= totalRows; i++) {
            String firstName = driver.findElement(By.xpath(String.format(cellLocator, i, 2))).getText();
            String lastName = driver.findElement(By.xpath(String.format(cellLocator, i, 1))).getText();
            String dueValue = driver.findElement(By.xpath(String.format(cellLocator, i, 4))).getText();
            table1Person.add(new Person(firstName, lastName, dueValue));
        }

        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDueValue))
                .get();

        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    }

    @Test
    void verifyMaxDueValuePersonUsingObjectInsideObjectGetMax() {
        List<Person> table1Person = new ArrayList<>();

        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(cell -> {
                    List<String> cells = cell.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    table1Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });
        Person maxDueValuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDueValue))
                .get();
        Assert.assertEquals(maxDueValuePerson.getFullName(), "Jason Doe");
    }

    @Test
    void verifyMinDueValuePersonUsingObjectInsideObjectGetMin() {
        List<Person> personList = new ArrayList<>();

        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    personList.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });

        Person minDueValuePerson = personList
                .stream()
                .min(Comparator.comparing(Person::getDueValue))
                .get();

        List<String> listMinDueValuePersonFullName = personList
                .stream()
                .filter(person -> person.getDueValue() == minDueValuePerson.getDueValue())
                .map(Person::getFullName)
                .toList();

        Assert.assertEquals(listMinDueValuePersonFullName, List.of("John Smith", "Tim Conway"));

    }
}
