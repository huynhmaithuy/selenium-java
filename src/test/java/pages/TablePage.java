package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TablePage extends BasePage {

    @Override
    public void open() {
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    public Person getPersonWithLargestDue() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        List<Person> persons = rows.stream().map(element -> {
            return toPerson(element);
        }).collect(Collectors.toList());

        List<Float> dues = persons.stream().map(Person::getDue).collect(Collectors.toList());
        persons.stream().forEach(person -> System.out.println(person.getDue()));
        int largestDueIndex = getLargestIndex(dues);
        System.out.println("largest = " + largestDueIndex);
        System.out.println("first name "+ persons.get(3).getFirstName());
        return toPerson(rows.get(largestDueIndex));
    }

    private Person toPerson(WebElement element) {
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstName = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td")).get(3).getText().
                trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();

        return new Person(lastName, firstName, email, website, due);
    }

    static int getLargestIndex(List<Float> a) {
        int largestindex = 0;
        //Float largest = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > a.get(largestindex)) {
                //largest = a.get(i);
                largestindex = i;
            }
        }
        return largestindex;
    }
}
