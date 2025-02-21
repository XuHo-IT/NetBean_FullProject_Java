package SORT;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // Find the maximum element in the array
        int max = Arrays.stream(arr).max().getAsInt();

        // Perform counting sort for each digit place (units, tens, hundreds, etc.)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // count array for digits 0 to 9

        // Count the occurrences of each digit at the given exponent place
        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // Modify the count array to store the actual position of each element in the sorted array
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the sorted array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy the sorted elements from the output array to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Array before sorting:");
        printArray(arr);

        radixSort(arr);

        System.out.println("\nArray after sorting:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
