package takeUForward.recursion;

import java.util.ArrayList;
import java.util.List;

public class CountInversionsInAnArray {
    static int count = 0;
    public static int numberOfInversions(int []a, int n) {
        count = 0;
        mergeSort(a, 0, n-1);
        return count;
    }

    private static void mergeSort(int[] a, int low, int high) {
        if ( low >= high) return;
        int mid = low + (high-low)/2;
        mergeSort(a, low, mid);
        mergeSort(a, mid+1, high);
        merge(a, low, mid, high);
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> temp = new ArrayList<>();
        while ( left <= mid && right <= high){
            if ( a[left] <= a[right]){
                temp.add(a[left]);
                left++;
            } else {
                temp.add(a[right]);
                count += mid-left+1;
                right++;
            }
        }

        while ( left <= mid){
            temp.add(a[left]);
            left++;
        }

        while ( right <= high){
            temp.add(a[right]);
            right++;
        }
        for ( int i=low; i<=high; i++){
            a[i] = temp.get(i-low);
        }
    }
}
