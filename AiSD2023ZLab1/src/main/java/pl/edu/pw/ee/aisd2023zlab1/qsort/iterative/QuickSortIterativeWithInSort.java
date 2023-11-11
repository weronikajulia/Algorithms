package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.ArrayList;
import java.util.List;

import static pl.edu.pw.ee.aisd2023zlab1.utils.Utils.swap;

public class QuickSortIterativeWithInSort implements Sorting {
    private static final int START_INSERTION_SORT = 20;

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }

        quicksort(nums);
    }

    private void quicksort(double[] data) {
        if (data.length < START_INSERTION_SORT)
            insertionSort(data);
        else {
            List<Integer> starts = new ArrayList<>();
            List<Integer> ends = new ArrayList<>();

            Integer left = 0;
            Integer right = data.length - 1;

            starts.add(left);
            ends.add(right);

            int n = 1;
            int pivot;

            if (left < right) {

                while (n > 0) {
                    n--;

                    left = starts.get(n);
                    starts.remove(left);

                    right = ends.get(n);
                    ends.remove(right);

                    pivot = splitData(data, left, right);

                    if (pivot - 1 > left) {
                        starts.add(left);
                        ends.add(pivot - 1);
                        n++;
                    }

                    if (pivot + 1 < right) {
                        starts.add(pivot + 1);
                        ends.add(right);
                        n++;
                    }
                }
            }
        }
    }

    private int splitData(double[] data, int start, int end) {
        int left = start + 1;
        int right = end;

        while (left < right) {
            while (left < right && data[left] < data[start]) {
                left++;
            }

            while (left < right && data[right] >= data[start]) {
                right--;
            }

            swap(data, left, right);
        }

        if (data[left] >= data[start]) {
            left--;
        }

        swap(data, start, left);

        return left;
    }


    private void insertionSort(double[] data) {
        int i, j;
        for (i = 1; i < data.length; i++) {
            double pom = data[i];
            j = i - 1;
            while (j >= 0 && data[j] > pom) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = pom;
        }
    }
}
