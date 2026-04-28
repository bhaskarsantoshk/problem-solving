package takeUForward.striver79;

import java.util.ArrayList;
import java.util.List;

public class P7CountInversions {

    public long numberOfInversions(int[] nums) {
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                if ( nums[i] > nums[j]) count++;
            }
        }
        return count;
    }

    long count = 0;
    public long numberOfInversionsOptimal(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return count;
    }



    // Pre-requisite

    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int low, int high) {
        if ( low == high) return;
        int mid = (low + high)/2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);
        //merge(nums, low, mid, high);
        mergeModified(nums, low, mid, high);
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while ( left <= mid && right <= high){
            if ( nums[left] <= nums[right]) temp.add(nums[left++]);
            else temp.add(nums[right++]);
        }
        while ( left <= mid) temp.add(nums[left++]);
        while (  right <= high) temp.add(nums[right++]);

        for ( int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }
    }

    // modified

    private void mergeModified(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1;
        while ( left <= mid && right <= high){
            if ( nums[left] <= nums[right]) temp.add(nums[left++]);
            // Right is smaller
            else {
                temp.add(nums[right++]);
                count+= (mid-left+1);
            }
        }
        while ( left <= mid) temp.add(nums[left++]);
        while (  right <= high) temp.add(nums[right++]);

        for ( int i=low; i<=high; i++){
            nums[i] = temp.get(i-low);
        }
    }
}
