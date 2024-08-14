package takeuForward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public void mergeSort( int [] nums){
        mergeSort(nums, 0, nums.length-1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if ( low >= high ) return;
        int mid = low + ( high - low)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        merge( nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        int[] temp = new int[high - low + 1]; // List<Integer> temp = new ArrayList<>();
        int mergedIndex = 0;
        while ( left <= mid && right <= high){
            if ( nums[left] <= nums[right]){
                temp[mergedIndex++] = nums[left];
                left++;
            } else {
                temp[mergedIndex++] = nums[right];
                right++;
            }
        }
        while ( left <= mid) temp[mergedIndex++] = nums[left++];
        while ( right <= high ) temp[mergedIndex++] = nums[right++];

        for ( int i=low; i<=high; i++){
            nums[i] = temp[i-low];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        // Test Case 1: Already sorted array
        int[] testCase1 = {1, 2, 3, 4, 5};
        mergeSort.mergeSort(testCase1);
        System.out.println("Test Case 1: " + Arrays.toString(testCase1)); // Expected: [1, 2, 3, 4, 5]

        // Test Case 2: Reverse sorted array
        int[] testCase2 = {5, 4, 3, 2, 1};
        mergeSort.mergeSort(testCase2);
        System.out.println("Test Case 2: " + Arrays.toString(testCase2)); // Expected: [1, 2, 3, 4, 5]

        // Test Case 3: Array with duplicates
        int[] testCase3 = {4, 1, 3, 4, 2, 1};
        mergeSort.mergeSort(testCase3);
        System.out.println("Test Case 3: " + Arrays.toString(testCase3)); // Expected: [1, 1, 2, 3, 4, 4]

        // Test Case 4: Array with a single element
        int[] testCase4 = {1};
        mergeSort.mergeSort(testCase4);
        System.out.println("Test Case 4: " + Arrays.toString(testCase4)); // Expected: [1]

        // Test Case 5: Array with all elements the same
        int[] testCase5 = {2, 2, 2, 2, 2};
        mergeSort.mergeSort(testCase5);
        System.out.println("Test Case 5: " + Arrays.toString(testCase5)); // Expected: [2, 2, 2, 2, 2]

        // Test Case 6: Array with negative and positive numbers
        int[] testCase6 = {-3, 5, -1, 7, -4, 2};
        mergeSort.mergeSort(testCase6);
        System.out.println("Test Case 6: " + Arrays.toString(testCase6)); // Expected: [-4, -3, -1, 2, 5, 7]

        // Test Case 7: Empty array
        int[] testCase7 = {};
        mergeSort.mergeSort(testCase7);
        System.out.println("Test Case 7: " + Arrays.toString(testCase7)); // Expected: []

        // Test Case 8: Large array
        int[] testCase8 = {100, -5, 20, 50, 1, 2, 3, -10, 30, 70};
        mergeSort.mergeSort(testCase8);
        System.out.println("Test Case 8: " + Arrays.toString(testCase8)); // Expected: [-10, -5, 1, 2, 3, 20, 30, 50, 70, 100]
    }
}
