# Selenium Java

## I. src/main/java/coding/practice
1. [Bai1](src/main/java/coding/practice/Bai1.java)
* Đề bài: Thay đổi ký tự đặc biệt trong 1 chuỗi cho trước

2. [Bai2](src/main/java/coding/practice/Bai2.java)
* Đề bài: Lấy 4 ký tự cuối cùng của một chuỗi cho trước

3. [Bai3](src/main/java/coding/practice/Bai3.java)
* Đề bài: Tìm ký tự không lặp lại đầu tiên của một chuỗi

4. [Bai4](src/main/java/coding/practice/Bai4.java)
* Đề bài: Tìm số lớn nhất và lớn thứ 2 của một mảng

5. [Bai5](src/main/java/coding/practice/Bai5.java)
* Đề bài: Tìm độ lệch lớn nhất giữa 2 phần tử trong một mảng

6. [Bai6](src/main/java/coding/practice/Bai6.java)
* Đề bài: Tìm vị trí của các số lặp lại trong mảng

## II. src/main/java/org/example/practice1
loading...

## III. src/main/java/org/example/practice2
loading...

## IV. src/main/java/org/example/practice2/starwar
loading...

## V. src/test/java/browsers
loading...

## VI. src/test/java/org/example/practice1
loading...

## VII. src/test/java/theInternet
### 1. [WebTableTest](src/test/java/theInternet/WebTableTest.java)

#### 1.1 Get and print all cells
  * Method 1: Using for loop
```java
int totalRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
int totalColumns = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();

String cellLocator = "//table[@id='table1']/tbody/tr[%d]/td[%d]";

for (int i = 1; i <= totalRows; i++) {
    for(int j = 1; j <= totalColumns; j++) {
        WebElement cell = driver.findElement(By.xpath(String.format(cellLocator, i, j)));
        System.out.println(cell.getText());
    }
}
```  

* Method 2: Using stream

```java
 driver
        .findElements(By.xpath("//table[@id='table1']/tbody/tr/td"))
        .stream()
        .forEach(element -> System.out.println(element.getText()));
``` 
#### 1.2 Get and print all data in column

```java
 driver
        .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
        .forEach(webElement -> System.out.println(Double.parseDouble(webElement.getText().replace("$", ""))));
``` 

#### 1.3 Get max in a column

```java
 double dueValue = driver
        .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
        .stream()
        .mapToDouble(webElement -> Double.parseDouble(webElement.getText().replace("$", "")))
        .max()
        .getAsDouble();
``` 

#### 1.4 Get value of due column

```java
 double[] dueValue = driver
        .findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"))
        .stream()
        .mapToDouble(due -> Double.parseDouble(due.getText().replace("$", "")))
        .toArray();
```

#### 1.5. Steps to resolve 

   * get value of due column
   * -> find max due value
   * -> find index of max due value = row 
   * -> get firstName of max due + get lastName of max due 
   * verify
------
craw data

```java
for (int i = 1; i <= totalRows; i++) {
    String firstName = driver.findElement(By.xpath(String.format(cellLocator, i, 2))).getText();
    String lastName = driver.findElement(By.xpath(String.format(cellLocator, i, 1))).getText();
    String dueValue = driver.findElement(By.xpath(String.format(cellLocator, i, 4))).getText();
    personList.add(new Person(firstName, lastName, dueValue));
}
```

đối tượng trong đối tượng
```java
driver
    .findElements(By.xpath("//table[@id='table1']/tbody/tr"))
    .stream()
    .forEach(row -> {
        String lblName = row.findElement(By.tagName("td")).getText();
        System.out.println(lblName);
    });
```


        List<Person> personList = new ArrayList<>();

        driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"))
                .forEach(cell -> {
                    List<String> cells = cell.findElements(By.tagName("td")).stream().map(WebElement::getText).toList();
                    personList.add(new Person(cells.get(1), cells.get(0), cells.get(3)));
                });

        Person minDueValue = personList
                .stream()
                .min(Comparator.comparing(Person::getDueValue))
                .get();

        List<String> minDueValuePerson = personList
                .stream()
                .filter(person -> person.getDueValue() == minDueValue.getDueValue())
                .map(Person::getFullName)
                .toList();
        Assert.assertEquals(minDueValuePerson, List.of("John Smith", "Tim Conway"));