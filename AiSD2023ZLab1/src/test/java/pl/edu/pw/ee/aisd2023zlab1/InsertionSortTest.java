package pl.edu.pw.ee.aisd2023zlab1;

import org.junit.Assert;
import org.junit.Test;
import pl.edu.pw.ee.aisd2023zlab1.utils.GeneralSortTest;


public class InsertionSortTest extends GeneralSortTest {
    public InsertionSortTest() {
        super(new InsertionSort());
    }
    @Test
    public void should_ReturnSortedArray_WhenInpArrHasManySameElem() {

        // given
        double[] nums = {3, 3, 3, 1, 1, 1, 1, 1, 1, 4, 5, 6};

        // when
        sorter.sort(nums);

        //then
        double[] expected = {1, 1, 1, 1, 1, 1, 3, 3, 3, 4, 5, 6};
        Assert.assertArrayEquals(expected, nums, 0);
    }
}
