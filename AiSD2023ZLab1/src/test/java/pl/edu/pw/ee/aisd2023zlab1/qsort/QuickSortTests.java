package pl.edu.pw.ee.aisd2023zlab1.qsort;

import org.junit.Test;
import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;
import pl.edu.pw.ee.aisd2023zlab1.utils.GeneralSortTest;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class QuickSortTests extends GeneralSortTest {
    public QuickSortTests(Sorting sorter) {
        super(sorter);
    }

    @Test
    public void should_ReturnSortedArray_WhenInputIsRandomAndSuperHuge() {
        // given
        int size = 524288;
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
