package SEARCH;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1; // If array is empty, return -1 indicating element not found
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Return the index where the target element is found
            }
        }

        return -1; // If element is not found, return -1
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 7, 1, 9, 5};
        int target = 7;

        int index = linearSearch(arr, target);

        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found in the array");
        }
    }
}

