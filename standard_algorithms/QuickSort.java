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
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
            }
        }

        // Swap pivot element with the element at index i-1
        int temp = array[low];
        array[low] = array[i - 1];
        array[i - 1] = temp;

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
