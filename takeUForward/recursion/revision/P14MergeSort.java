package takeUForward.recursion.revision;

import java.util.ArrayList;
import java.util.List;

public class P14MergeSort {
    public static void mergeSort(int[] arr, int n) {
        mergeSort(arr, 0, n-1);
    }

    private static void mergeSort(int[] arr, int low, int high) {
       if ( low >= high ) return;
       int mid = (low + high)/2;
       mergeSort(arr, low, mid);
       mergeSort(arr, mid+1, high);
       merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while ( left <= mid && right <= high){
            if ( arr[left] <= arr[right]){
                temp.add(arr[left++]);
            } else{
                temp.add(arr[right++]);
            }
        }
        while ( left <= mid ){
            temp.add(arr[left++]);
        }
        while ( right <= high ){
            temp.add(arr[right++]);
        }
        int index = 0;
        for ( int i=low; i<=high; i++){
            arr[i] = temp.get(index++); // temp.get(i-low);
        }
    }
}
