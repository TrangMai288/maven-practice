package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WebTableTestNewVersion {
    List<Person> table1Person;

    @BeforeClass
    void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        table1Person = new ArrayList<>();
        driver
                .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(row -> {
                    List<String> cells = row.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    table1Person.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });
    }

    @Test
    void verifyMaxDueValuePerson() {
        Person maxDuePerson = table1Person
                .stream()
                .max(Comparator.comparing(Person::getDueValue))
                .get();
        Assert.assertEquals(maxDuePerson.getFullName(), "Jason Doe");
    }

    @Test
    void verifyMinDueValuePerson() {
        Person minDuePerson = table1Person
                .stream()
                .min(Comparator.comparing(Person::getDueValue))
                .get();

        List<String> minDuePersonFullName = table1Person
                .stream()
                .filter(person -> person.getDueValue() == minDuePerson.getDueValue())
                .map(Person::getFullName)
                .toList();
        Assert.assertEquals(minDuePersonFullName, List.of("John Smith", "Tim Conway"));
    }
}
