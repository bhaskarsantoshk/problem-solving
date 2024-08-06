package striver_sde_sheet.recursion_and_backtracking;

import java.util.List;

public class QuickSort {
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
