package SORT;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void bucketSort(double[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        int n = arr.length;
        int numBuckets = 10; // Number of buckets
        ArrayList<Double>[] buckets = new ArrayList[numBuckets];

        // Initialize buckets
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Put array elements in their respective buckets
        for (double value : arr) {
            int bucketIndex = (int) (value * numBuckets);
            buckets[bucketIndex].add(value);
        }

        // Sort individual buckets
        for (ArrayList<Double> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate sorted buckets to get the sorted array
        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            for (double value : bucket) {
                arr[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        double[] arr = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
        System.out.println("Array before sorting:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("\nArray after sorting:");
        printArray(arr);
    }

    public static void printArray(double[] arr) {
        for (double num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

