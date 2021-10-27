import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public class DatabaseTest {
    private Database database;
    private static final Integer[] NUMBERS = {22, 85, 18, 52,71};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }

    @Test
    public void testConstructorHasToCreateValidObject(){
        Assert.assertEquals(database.getElements().length, NUMBERS.length);
        for (int i = 0; i < database.getElements().length; i++) {
            Assert.assertEquals(database.getElements()[i], NUMBERS[i]);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNumbersThanBiggerThanSixteen() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[17];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNumbersThanLessThanOne() throws OperationNotSupportedException {
        Integer[] numbers = new Integer[0];
        new Database(numbers);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddShouldThrowWhenParametersNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddShouldAddElement() throws OperationNotSupportedException {
        database.add(9);
        Assert.assertEquals(database.getElements().length, 6);
        Assert.assertEquals(database.getElements()[5], Integer.valueOf(9));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveShouldEmptyDate() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testRemoveLastElement() throws OperationNotSupportedException {
        database.remove();

        Assert.assertEquals(database.getElements().length, NUMBERS.length - 1);
        Assert.assertEquals(database.getElements()[database.getElements().length - 1], Integer.valueOf(52)) ;
    }
}
