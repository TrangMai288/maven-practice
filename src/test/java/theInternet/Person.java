package theInternet;

public class Person {
    private String firstName;
    private String lastName;
    private String dueValue;

    public Person(String firstName, String lastName, String dueValue) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dueValue = dueValue;
    }

    public double getDueValue() {
        return Double.parseDouble(dueValue.replace("$", ""));
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
