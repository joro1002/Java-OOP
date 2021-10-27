import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleTest {
    @Test
    public void testBubble() {
        int[] numbers = {91, 3, 71, 913, 9, 10, 1825, 1};
        Bubble.sort(numbers);

        int[] expectedNumbers = {1, 3, 9, 10, 71, 91, 913, 1825};
        Assert.assertEquals(numbers.length, expectedNumbers.length);
        for (int i = 0; i < numbers.length; i++) {
            Assert.assertEquals(numbers[i], expectedNumbers[i]);
        }
    }

}
