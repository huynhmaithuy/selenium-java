package findElement;

public class OnePerson {
    String lastName;
    String firstName;
    String email;
    String website;
    Float due;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public OnePerson(String lastName, String firstName, String email, Float due, String website) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.website = website;
        this.due = due;
    }
}
