package pl.edu.pw.ee.aisd2023zlab1;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

public class InsertionSort implements Sorting {
    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }
        int i, j;
        for (i = 1; i < nums.length; i++) {
            double pom = nums[i];
            j = i - 1;
            while (j >= 0 && nums[j] > pom) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = pom;
        }
    }
}

