package findElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.geom.FlatteningPathIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TableTest1 {
    @Test
    void validateLargestDueAmount(){
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/tables");
    driver.manage().window().maximize();
    List<WebElement> listOfDue =  driver.findElements(By.xpath("//*[@id='table1']/tbody/tr/td[4]"));
//    List<Float> dues = new ArrayList<>();
//    listOfDue.forEach(element -> dues.add(Float.valueOf(element.getText().trim().replace("$",""))));
    List<Float> dues = listOfDue
            .stream()
            .map
                    (element -> {return Float.valueOf(element.getText().trim().replace("$",""));
                    }).collect(Collectors.toList());

    int largestIndex = getLargestIndex(dues);
    String firstNameLocator = "//*[@id='table1']//tr[%s]/td[2]";
    String lastNameLocator = "//*[@id='table1']//tr[%s]/td[1]";
    String firstName = driver.findElement(By.xpath(String.format(firstNameLocator,largestIndex))).getText();
    String lastName = driver.findElement(By.xpath(String.format(lastNameLocator,largestIndex))).getText();
        Assert.assertEquals(lastName, "Doe");
        //String firstName = driver.findElement(By.xpath("//*[@id='table1']//tr["+largestIndex+"]/td[2]")).getText();
        //String lastName = driver.
//                findElement(By.xpath("//*[@id='table1']//tr["+largestIndex+"]/td[1]")).getText();
        Assert.assertEquals(firstName, "Jason");
        System.out.println("first name, last name: "+ firstName +" "+ lastName);
    }

    int getLargestIndex(List<Float> l){
        int largestIndex = 0;
        for(int i=1; i<l.size();i++){
            if(l.get(largestIndex) < l.get(i)){
                largestIndex = i;
            }
        }
        return largestIndex+1;
    }

    @Test
//    public void allCellValue(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/tables");
//        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
//        List<OnePerson> persons =
//                rows
//                        .stream()
//                        .map(element -> {return toPerson(element);}).collect(Collectors.toList());
//
//        List<Float> dues = persons.stream().map(OnePerson::getDue).collect(Collectors.toList());
//        persons.stream().forEach(a-> System.out.println(a.getDue()));
//
//    }
//    public OnePerson toPerson(WebElement element){
//        String lastName = element.findElements(By.tagName("td")).get(0).getText();
//        String firstName = element.findElements(By.tagName("td")).get(1).getText();
//        String email = element.findElements(By.tagName("td")).get(2).getText();
//        Float due = Float.valueOf(element.findElements
//                (By.tagName("td")).get(3).getText().trim().replace("$",""));
//        String website = element.findElements(By.tagName("td")).get(4).getText();
//        return new OnePerson(lastName,firstName,email,due,website);
//    }

    public void allCellValue(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='table1']/tbody/tr"));
        List<Person> persons = rows.stream()
                .map(element -> {return toOnePerson(element);}).collect(Collectors.toList());

        List<Float> dues = persons.stream().map(Person::getDue).collect(Collectors.toList());
        persons.stream().forEach(a -> System.out.println(a.getDue()));
        dues.forEach(aFloat -> System.out.println(aFloat));

    }

    public Person toOnePerson(WebElement element){
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstName = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td"))
                .get(3).getText().trim().replace("$",""));
        String website = element.findElements(By.tagName("td")).get(4).getText();

        return new Person(lastName,firstName,email,website,due);

    }
}

