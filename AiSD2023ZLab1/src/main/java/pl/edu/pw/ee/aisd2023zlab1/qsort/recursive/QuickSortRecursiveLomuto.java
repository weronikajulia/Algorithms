package pl.edu.pw.ee.aisd2023zlab1.qsort.recursive;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import static java.util.Objects.isNull;
import static pl.edu.pw.ee.aisd2023zlab1.utils.Utils.swap;

public class QuickSortRecursiveLomuto implements Sorting {

    @Override
    public void sort(double[] nums) {
        validateParams(nums);

        int left = 0;
        int right = nums.length - 1;

        quickSort(nums, left, right);
    }

    private void validateParams(double[] nums) {
        if (isNull(nums)) {
            throw new RuntimeException("Input args (nums) cannot be null!");
        }
    }

    private void quickSort(double[] nums, int left, int right) {
        if (left < right) {

            int pivotId = partition(nums, left, right);

            quickSort(nums, left, pivotId - 1);
            quickSort(nums, pivotId + 1, right);
        }
    }

    private int partition(double[] nums, int start, int end) {
        double pivot = nums[end];

        int i = start - 1;
        int j = start;

        while (j < end) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }

        int pivotId = ++i;
        swap(nums, pivotId, end);

        return pivotId;
    }


}
