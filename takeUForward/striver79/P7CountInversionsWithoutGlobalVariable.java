package takeUForward.striver79;

import java.util.ArrayList;
import java.util.List;

public class P8CountInversionsWithoutGlobalVariable {

    public long numberOfInversionsOptimal(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    private long mergeSort(int[] nums, int low, int high) {
        long count = 0;
        if ( low == high) return count;
        int mid = (low + high)/2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid+1, high);
        count += merge(nums, low, mid, high);
        return count;
    }

    private long merge(int[] nums, int low, int mid, int high) {
        long count = 0;
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while ( left <= mid && right <= high){
            if ( nums[left] <= nums[right]) temp.add(nums[left++]);
            else {
                count += mid -left+1;
                temp.add(nums[right++]);
            }
        }
        while ( left <= mid) temp.add(nums[left++]);
        while (  right <= high) temp.add(nums[right++]);

        for ( int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }
        return count;
    }
}
