package takeUForward.heaps.revision;

public class HeapifyAlgorithmMinHeap {
    public void heapify(int[] nums, int ind, int val) {
        if ( ind < 0 || ind >= nums.length) return;
        if ( nums[ind] > val ){
            nums[ind] = val;
            heapifyUp(nums, ind);
        } else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }

    private void heapifyUp(int[] nums, int ind) {
        int parent = (ind-1)/2;
        if ( ind > 0 ){
            if ( nums[ind] < nums[parent]){
                swap(nums, ind, parent);
                heapifyUp(nums, parent);
            }
        }
    }

    private void heapifyDown(int[] nums, int ind) {
        int smallestIdx = ind;
        int left = 2 * ind+1;
        int right = 2 * ind + 2;
        if ( left < nums.length && nums[left] < nums[smallestIdx]) {
            smallestIdx = left;
        }
        if ( right < nums.length && nums[right] < nums[smallestIdx]){
            smallestIdx = right;
        }
        if ( smallestIdx != ind){
            swap(nums, smallestIdx, ind);
            heapifyDown(nums, smallestIdx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
