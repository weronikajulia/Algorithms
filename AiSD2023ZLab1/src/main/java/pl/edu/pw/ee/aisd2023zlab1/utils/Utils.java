package pl.edu.pw.ee.aisd2023zlab1.utils;

public final class Utils {
    private Utils() {
    }

    public static void swap(double[] arr, int firstId, int secondId) {
        if (firstId != secondId) {
            double swappedElement = arr[secondId];
            arr[secondId] = arr[firstId];
            arr[firstId] = swappedElement;
        }
    }

    public static void swap(int[] arr, int firstId, int secondId) {
        if (firstId != secondId) {
            int swappedElement = arr[secondId];
            arr[secondId] = arr[firstId];
            arr[firstId] = swappedElement;
        }
    }
}
