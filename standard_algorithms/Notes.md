# Gist for Merge Sort Algorithm in Java

## Problem:
Sort an array of integers using the merge sort algorithm, which is a divide-and-conquer algorithm with a time complexity of O(n log n).

## Key Insight:
Merge sort recursively splits the array into two halves, sorts each half, and then merges the sorted halves to produce the final sorted array.

## Steps:

1. **Recursive Splitting:**
    - **Why:** To break down the problem into smaller subproblems that are easier to solve.
    - **How:** Recursively call `mergeSort` to split the array into two halves until each subarray contains a single element.

2. **Merge Function:**
    - **Why:** To combine two sorted subarrays into a single sorted array.
    - **How:**
        - Create temporary arrays `leftArray` and `rightArray` to hold the elements of the two subarrays.
        - Copy the elements into these temporary arrays.
        - Merge the two arrays by comparing the elements and copying the smaller one into the original array.

3. **Handling Remaining Elements:**
    - **Why:** After merging the common elements, there might be leftover elements in either the left or right subarray.
    - **How:** Copy the remaining elements directly into the original array.

4. **Print the Array:**
    - **Why:** To visualize the array before and after sorting.
    - **How:** Implement a `printArray` method to iterate through the array and print its elements.

## Example:

Given the input array `[12, 11, 13, 5, 6, 7]`:

- The algorithm will recursively split the array into smaller subarrays, sort them, and merge them back to produce the sorted array `[5, 6, 7, 11, 12, 13]`.

## Code Implementation:

```java
package standard_algorithms;

public class MergeSort {

    // Main function that sorts an array using merge sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the two halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the two halves
            merge(array, left, mid, right);
        }
    }

    // Function to merge two halves of the array
    public static void merge(int[] array, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Function to print the array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the merge sort
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Given Array");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array");
        printArray(array);
    }
}
```
# Gist for Quick Sort Algorithm in Java

## Problem:
Sort an array of integers using the quick sort algorithm, a popular and efficient sorting algorithm with an average-case time complexity of O(n log n).

## Key Insight:
Quick sort works by selecting a "pivot" element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The process is then recursively applied to the sub-arrays.

## Steps:

1. **Recursive Quick Sort:**
   - **Why:** Quick sort divides the array into smaller sub-arrays to sort recursively, ensuring efficient sorting.
   - **How:**
      - If `low < high`, find the partition index using the `partition` function.
      - Recursively apply `quickSort` to the sub-arrays before and after the partition.

2. **Partition Function:**
   - **Why:** The partition function rearranges the array so that elements less than the pivot come before it, and elements greater come after it.
   - **How:**
      - Choose the first element as the pivot.
      - Iterate through the array, swapping elements to ensure all elements less than the pivot are on the left and all elements greater are on the right.
      - Finally, place the pivot in its correct position.

3. **Swap Function:**
   - **Why:** Swapping elements is necessary to move elements around the pivot.
   - **How:** Implement a helper method to swap elements at two indices in the array.

4. **Print the Array:**
   - **Why:** To visualize the array before and after sorting.
   - **How:** Implement a `printArray` method to iterate through the array and print its elements.

## Example:

Given the input array `[10, 7, 8, 9, 1, 5]`:

- The algorithm will sort the array to `[1, 5, 7, 8, 9, 10]`.

## Code Implementation:

```java
package standard_algorithms;

public class QuickSort {

    // Main function that implements QuickSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Find the pivot index with low as pivot
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Function to partition the array with the first element as the pivot
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low]; // Pivot is now the first element
        int i = low + 1; // Start from the element next to the pivot

        for (int j = low + 1; j <= high; j++) {
            // If current element is smaller than or equal to the pivot
            if (array[j] < pivot) {
                // Swap array[i] and array[j]
                swap(array, i, j);
                i++;
            }
        }

        // Swap pivot element with the element at index i-1
        swap(array, low, i - 1);

        return i - 1; // Return the partitioning index
    }

    // Function to print the array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // Main method to test the quick sort
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        System.out.println("Given Array");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.println("\nSorted array");
        printArray(array);
    }
}
```