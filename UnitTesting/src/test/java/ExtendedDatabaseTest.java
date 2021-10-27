import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class ExtendedDatabaseTest {

    private Database database;
    private static final Person[] PEOPLE = {new Person(1, "First"), new Person(2, "Second"),
            new Person(3, "Third")};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }

    @Test
    public void testCreateConstructorValidObject() {
        Assert.assertEquals(database.getElements().length, PEOPLE.length);

        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(PEOPLE[i], database.getElements()[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowWhenUseMoreThanSixteenElements() throws OperationNotSupportedException {
        Person[] people = new Person[17];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThanLessOneElements() throws OperationNotSupportedException {
        Person[] people = new Person[0];
        new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullParam() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddElement() throws OperationNotSupportedException {
        database.add(new Person(4, "Forth"));
        Assert.assertEquals(database.getElements().length, 4);
        Assert.assertEquals(database.getElements()[3].getId(), 4);
        Assert.assertEquals(database.getElements()[3].getUsername(), "Forth");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowExceptRemove() throws OperationNotSupportedException {
        Person[] people = database.getElements();
        for (int i = 0; i < people.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveElement() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(database.getElements().length, PEOPLE.length - 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1].getId(), 2);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1].getUsername(), "Second");
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i], PEOPLE[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindUsernameParamIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findByUsername("First");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findByUsername("First");
    }

    @Test
    public void testFindByUsernameReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findByUsername("First");
        //username = "First", id = 1
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowWithEmptyData() throws OperationNotSupportedException {
        database = new Database(null, null);
        database.findById(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowIfSizeIsNotEqualsOne() throws OperationNotSupportedException {
        database = new Database();
        database.findById(1);
    }

    @Test
    public void testFindByIdReturnCorrectPerson() throws OperationNotSupportedException {
        Person resultPerson = database.findById(1);
        Assert.assertEquals(1, resultPerson.getId());
        Assert.assertEquals("First", resultPerson.getUsername());

        Person resultPerson2 = database.findById(2);
        Assert.assertEquals(2, resultPerson2.getId());
        Assert.assertEquals("Second", resultPerson2.getUsername());
    }
}
