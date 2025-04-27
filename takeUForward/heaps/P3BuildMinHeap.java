package takeUForward.heaps;

public class P3BuildMinHeap {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;
        for ( int ind=n/2 - 1 ; ind >=0 ; ind--){
            heapifyDown(nums, ind);
        }
    }

    private void heapifyDown(int[] nums, int ind) {
        int smallestIdx = ind;
        int left = 2 * ind+1;
        int right = 2 * ind+2;
        if ( left < nums.length && nums[left] < nums[smallestIdx]){
            smallestIdx = left;
        }
        if ( right < nums.length && nums[right] < nums[smallestIdx]){
            smallestIdx = right;
        }
        if ( ind != smallestIdx){
            swap(nums, ind, smallestIdx);
            heapifyDown(nums, smallestIdx );
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }
}
