package takeUForward.recursion;

import java.util.List;

public class QuickSort {
    public void quickSort( int [] nums){
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if ( low < high ){
            int partitionIndex = findPivot(nums, low, high);
            quickSort(nums, low, partitionIndex-1);
            quickSort(nums, partitionIndex+1, high);
        }
    }

    private int findPivot(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low;
        int j= high;

        while ( i <= j){
            while ( i <= high && nums[i] <= pivot) i++;
            while ( j >= low && nums[j] > pivot) j--;
            if ( i < j){
                swap(nums, i ,j);
            }
        }
        swap(nums, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static List<Integer> quickSort(List<Integer> arr){
        quickSortRec(arr, 0, arr.size()-1);
        return arr;
    }

    private static void  quickSortRec(List<Integer> a, int low, int high) {
        if ( low < high){
            int partition = findPartition(a, low, high);
            quickSortRec(a, low, partition-1);
            quickSortRec(a, partition+1, high);
        }
    }

    private static int findPartition(List<Integer> a, int low, int high) {
        int pivot = a.get(low);
        int i=low, j= high;
        while (i < j) {
            while (i <= high && a.get(i) <= pivot) {
                i++;
            }
            while (j >= low && a.get(j) > pivot) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }
        swap(a, low, j);
        return j;
    }

    private static void swap(List<Integer> a, int i, int j) {
        int temp = a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
    }
}
