import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class IteratorTest {
    private ListIterator listIterator;
    private static final String[] DATA = {"Ivo", "Kiril", "Georgi", "Desi"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(DATA);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextAndMove() {
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();

        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();

        Assert.assertTrue(listIterator.hasNext());
        listIterator.move();

        Assert.assertFalse(listIterator.hasNext());
        listIterator.move();

        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintEmptyData() throws OperationNotSupportedException {
        ListIterator iterator = new ListIterator();
        iterator.print();
    }

    @Test
    public void testPrintWithElement(){
        int index = 0;

        while (listIterator.hasNext()){
            Assert.assertEquals(listIterator.print(), DATA[index]);
            index++;
            listIterator.move();
        }
    }
}
