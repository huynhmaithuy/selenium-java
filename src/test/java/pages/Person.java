package pages;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String website;
    private Float due;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Float getDue() {
        return due;
    }

    public void setDue(Float due) {
        this.due = due;
    }

    public Person(String firstName, String lastName, String email, String website, Float due) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.website = website;
        this.due = due;
    }

}
