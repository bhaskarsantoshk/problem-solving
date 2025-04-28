package takeUForward.heaps.revision;

public class P7ConvertMinHeapToMaxHeap {
    public int[] minToMaxHeap(int[] nums) {
        int n = nums.length;
        for ( int i=n/2-1; i>=0; i--){
            heapifyDown(nums, i);
        }
        return nums;
    }

    private void heapifyDown(int[] nums, int ind) {
        int maxIdx = ind;
        int n = nums.length;
        int left = 2 * ind+1;
        int right = 2 * ind+2;

        if ( left < n && nums[left] > nums[maxIdx]){
            maxIdx = left;
        }
        if ( right < n && nums[right] > nums[maxIdx]){
            maxIdx = right;
        }
        if ( maxIdx != ind){
            int temp = nums[ind];
            nums[ind] = nums[maxIdx];
            nums[maxIdx] = temp;
            heapifyDown(nums, maxIdx);
        }
    }
}
