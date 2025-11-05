package takeUForward.QR;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public void mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length-1);
    }

    private void mergeSort(int[] nums, int start, int end){
        if ( start >= end) return;
        int mid = (start+end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        List<Integer> list = new ArrayList<>();
        int left = start, right = mid+1;
        while ( left <= mid && right <= end){
            if ( nums[left] > nums[right]) list.add(nums[left++]);
            else list.add(nums[right++]);
        }
        while ( left <= mid) list.add(nums[left++]);
        while ( right <= end) list.add(nums[right]);

        for ( int i=start; i<=end; i++){
            nums[i] = list.get(i-start);
        }
    }
}
