package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.ArrayList;
import java.util.List;

import static pl.edu.pw.ee.aisd2023zlab1.utils.Utils.swap;

public class QuickSortIterative implements Sorting {

    @Override
    public void sort(double[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }

        quicksort(nums);
    }

    private void quicksort(double[] data) {
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


}
