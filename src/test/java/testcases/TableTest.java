package testcases;

import pages.Person;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TablePage;

//all cells //table/tbody/tr/td
// number of columns //table/thead/tr/td
//number of row //table/tbody/tr
//one colum //table/tbody/tr/td[index]
//one row //table/tbody/[tr[index]/td
//a table Array[row][column]
//
public class TableTest extends BaseTest {
    @Test
    void largestDuePerson() {
        TablePage tablePage = new TablePage();
        tablePage.open();
        Person personWithLargestDue = tablePage.getPersonWithLargestDue();
        //Assert.assertEquals(String.format("%s %s", lastName, firstName), "Doe Jason");
        Assert.assertEquals
                (String.format("%s %s", personWithLargestDue.getFirstName()
                        , personWithLargestDue.getLastName()), "Doe Jason");
    }
}
