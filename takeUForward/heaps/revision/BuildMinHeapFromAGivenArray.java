package takeUForward.heaps.revision;

public class BuildMinHeapFromAGivenArray {
    public void buildMinHeap(int[] nums) {
        int n = nums.length;
        for ( int ind = (n/2)-1; ind>=0; ind--){
             heapifyDown(nums, ind);
        }
    }

    private void heapifyDown(int[] nums, int ind) {
        int smallIdx = ind;
        int left = 2 * ind+1;
        int right = 2*ind+2;
        if ( left < nums.length && nums[left] < nums[smallIdx]){
            smallIdx = left;
        }
        if ( right < nums.length && nums[right] < nums[smallIdx]){
            smallIdx = right;
        }
        if ( ind != smallIdx){
            swap(nums, smallIdx, ind);
            heapifyDown(nums, smallIdx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//       0
//     1    2
//    3 4  5 6
