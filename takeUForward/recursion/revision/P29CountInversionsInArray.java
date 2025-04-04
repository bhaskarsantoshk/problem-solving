package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.List;

public class P29CountInversionsInArray {
    static int count = 0;
    public static long getInversions(long arr[], int n) {
        mergeSort(arr, 0, n-1);
        return count;
    }

    public static void mergeSort(long[] arr, int n) {
        mergeSort(arr, 0, n-1);
    }

    private static void mergeSort(long[] arr, int low, int high) {
        if ( low >= high ) return;
        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    private static void merge(long[] arr, int low, int mid, int high) {
        List<Long> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while ( left <= mid && right <= high){
            if ( arr[left] <= arr[right]){
                temp.add(arr[left++]);
            } else{
                count+= (mid-left+1);
                temp.add(arr[right++]);
            }
        }
        int index = 0;
        for ( int i=low; i<=high; i++){
            arr[i] = temp.get(index++); // temp.get(i-low);
        }
    }
}
