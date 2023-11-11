package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;


import org.junit.Test;
import pl.edu.pw.ee.aisd2023zlab1.qsort.QuickSortTests;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortIterativeWithInSortTest extends QuickSortTests {
    public QuickSortIterativeWithInSortTest() {
        super(new QuickSortIterativeWithInSort());

    }
    @Test
    public void should_ReturnSortedArray_WhenInputIsRandomAndHas25Elements() {
        // given
        int size = 25;
        double[] nums = createRandomData(size);
        double[] numsCopy = nums.clone();

        // when
        sorter.sort(nums);

        // then
        assertThat(nums)
                .isSorted()
                .containsExactlyInAnyOrder(numsCopy);
    }
}
