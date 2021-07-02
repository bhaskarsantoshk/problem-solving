package data_structures.arrays;

import static Recursion.DataFormatter.swap;

public class QuickSort {
    public static void quickSort(int[] a){
        quickSort(a,0,a.length-1);
    }

    private static void quickSort(int[] a, int start, int end) {
        if ( end > start){
            int pivotIndex = partition(a, start, end);
            quickSort(a, start, pivotIndex-1);
            quickSort(a, pivotIndex+1, end);
        }
    }

    private static int partition(int[] a, int start, int end) {
        int pIndex = start;
        int pivot = a[end];
        for ( int i=start; i<end-1; i++){
            if (a[i]<=pivot){
                swap(a,i, pIndex);
            }
        }
        swap(a,pIndex, end);
        return pIndex;
    }
}
