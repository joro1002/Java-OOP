import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ChainblockImplTest {
    private Chainblock chainblock;
    private List<Transaction> transactionsList;

    @Before
    public void setUp() {
        this.chainblock = new ChainblockImpl();
        this.transactionsList = new ArrayList<>();
        prepareTransactions();
    }

    private void prepareTransactions() {
        Transaction firstTransaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.90);
        Transaction secondTransaction = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.80);
        Transaction thirdTransaction = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Desi", "Pesho", 10.70);
        Transaction forthTransaction = new TransactionImpl(4, TransactionStatus.FAILED, "Desi", "Pesho", 10.60);
        this.transactionsList.add(firstTransaction);
        this.transactionsList.add(secondTransaction);
        this.transactionsList.add(thirdTransaction);
        this.transactionsList.add(forthTransaction);
    }


    private void fillChainblock() {
        chainblock.forEach(transaction -> chainblock.add(transaction));
    }

    @Test
    public void testContains() {
        Transaction transaction = this.transactionsList.get(0);
        Assert.assertFalse(this.chainblock.contains(transaction));
        this.chainblock.add(transaction);
        Assert.assertTrue(this.chainblock.contains(transaction));
    }

    @Test
    public void testAddCorrectTransaction(){
        this.chainblock.add(transactionsList.get(0));
        Assert.assertEquals(1, this.chainblock.getCount());
        this.chainblock.add(transactionsList.get(1));
        Assert.assertEquals(2, this.chainblock.getCount());
    }

    @Test
    public void testAddExistingTransaction(){
        this.chainblock.add(transactionsList.get(0));
        Assert.assertEquals(1, this.chainblock.getCount());
        this.chainblock.add(transactionsList.get(0));
        Assert.assertEquals(1, this.chainblock.getCount());
    }
}
