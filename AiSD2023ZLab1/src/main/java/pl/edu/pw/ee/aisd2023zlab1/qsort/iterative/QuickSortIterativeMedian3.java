package pl.edu.pw.ee.aisd2023zlab1.qsort.iterative;

import pl.edu.pw.ee.aisd2023zlab1.services.Sorting;

import java.util.*;

import static pl.edu.pw.ee.aisd2023zlab1.utils.Utils.swap;

public class QuickSortIterativeMedian3 implements Sorting {

    @Override
    public void sort(double[] nums) {

        if (nums == null) {
            throw new IllegalArgumentException("Input args (nums) cannot be null!");
        }
        quicksortMedian3(nums);
    }

    private void quicksortMedian3(double[] data) {

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

                pivot = splitDataMedian3(data, left, right);

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

    private int findIndexOfMedian3FromRandomIndex(double[] data, int[] indexes) {
        double[] numbers = new double[3];

        for (int i = 0; i < 3; i++) {
            numbers[i] = data[indexes[i]];
        }

        Arrays.sort(numbers);
        double median = numbers[1];

        for (int i = 0; i < 3; i++) {
            if (data[indexes[i]] == median) {
                return indexes[i];
            }
        }
        return -1;
    }

    private int splitDataMedian3(double[] data, int start, int end) {
        if (end - start + 1 >= 3) {
            swap(data, start, findIndexOfMedian3FromRandomIndex(data, get3RandomIndexes(start, end)));
        }

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

    private int[] get3RandomIndexes(int start, int end) {

        Random random = new Random();
        HashSet<Integer> uniqueIndexes = new HashSet<>();
        int[] result = new int[3];

        while (uniqueIndexes.size() < 3) {
            int randomIndex = random.nextInt(end - start + 1) + start;
            uniqueIndexes.add(randomIndex);
        }

        int index = 0;
        for (Integer uniqueIndex : uniqueIndexes) {
            result[index++] = uniqueIndex;
        }

        return result;
    }

}





