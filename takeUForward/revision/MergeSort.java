package takeUForward.revision;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high){
        if ( low < high ){
            int mid = (low+high) /2;
            mergeSort( nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge ( nums , low, mid, high);
        }
    }

    private void merge(int []nums, int low, int mid, int high){
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while ( left <= mid && right <=high ){
            if ( nums[left] <= nums[right]) temp.add(nums[left++]);
            else temp.add(nums[right++]);
        }
        while( left <=mid ){
            temp.add(nums[left++]);
        }
        while (right <= high ) temp.add(nums[right++]);
        for ( int i=low; i<=high; i++){
            nums[i]=temp.get(i-low);
        }
    }
}
