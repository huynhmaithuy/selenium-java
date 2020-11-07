package findElement;

import org.apache.hc.client5.http.impl.routing.SystemDefaultRoutePlanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//all cells //table/tbody/tr/td
// number of columns //table/thead/tr/td
//number of row //table/tbody/tr
//one colum //table/tbody/tr/td[index]
//one row //table/tbody/[tr[index]/td
//a table Array[row][column]
//
public class TableTest {
    @Test
    void largestDuePerson() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> dueColumn = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[4]"));
        //List<Float> dues = new ArrayList<>();

        //System.out.println(dues);

        List<Float> dues =  dueColumn
                .stream()
                .map(element -> {
                    return Float.valueOf(element.getText().trim().replace("$",""));
                })
                .collect(Collectors.toList());

        //dueColumn.forEach(element -> dues.add(Float.valueOf(element.getText().trim().replace("$", ""))));
        String firstNameLocator = "//table[@id='table1']/tbody/tr[%s]/td[2]";
        String lastNameLocator = "//table[@id='table1']/tbody/tr[%s]/td[1]";

        //String firstName = driver.
        //        findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%s]/td[2]", getLargestIndex(dues)))).getText();
        String firstName = driver.
                        findElement(By.xpath(String.format(firstNameLocator, getLargestIndex(dues)))).getText();

//        String lastName = driver.
//                findElement(By.xpath(String.format("//table[@id='table1']/tbody/tr[%s]/td[1]", getLargestIndex(dues)))).getText();
        String lastName = driver.
                findElement(By.xpath(String.format(lastNameLocator, getLargestIndex(dues)))).getText();

        Assert.assertEquals(String.format("%s %s", lastName, firstName), "Doe Jason");
    }

    public static void main(String[] args) {
       /* //Double b = {50.0,51.0, 100.0, 50.0};
        List<Double> a = new ArrayList<>();
        a.add(50.0);
        a.add(51.0);
        a.add(100.0);
        a.add(50.0);
        Double largest = a.get(0);
        int largestindex = 0;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > largest) {
                // largest = a.get(i);
                // largestindex = i;
            }
        }*/

    }
    static int getLargestIndex(List <Float> a){
        int largestindex = 0;
        //Float largest = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > a.get(largestindex)) {
                //largest = a.get(i);
                largestindex = i;
            }

        }
        return largestindex+1;
    }
       @Test
        void allCellValue () {
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/tables");
           List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
            //List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td"));
            //rows.stream().forEach(element -> System.out.println(element.getText()));

            //rows.stream().forEach(element -> System.out.println(element.findElement(By.tagName("td")).getText()));

           List<Person> persons = rows.stream().map(element -> {
               return toPerson(element);
           }).collect(Collectors.toList());

           List<Float> dues = persons.stream().map(Person::getDue).collect(Collectors.toList());
           persons.stream().forEach(person -> System.out.println(person.getDue()));



            /*-----assert --------
            persons.forEach(person -> {
                Assert.assertEquals(person.getFirstName(), "");
            });

           for (Person p : persons) {

           }*/
        }

        private  Person toPerson(WebElement element){
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstName = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td")).get(3).getText().
                trim().replace("$",""));
        String website = element.findElements(By.tagName("td")).get(4).getText();

        return new Person(lastName,firstName,email,website, due);
        }

}
