package takeUForward.heaps;

public class P1HeapifyMinHeap {
    public void heapify(int[] nums, int ind, int val) {
        if (nums[ind] > val){
            nums[ind] = val;
            heapifyUp(nums, ind);
        } else {
            nums[ind] = val;
            heapifyDown(nums, ind);
        }
    }

    private void heapifyDown(int[] nums, int ind) {
        int leftChildIdx = 2 * ind +1;
        int rightChildIdx = 2 * ind+2;
        int smallest_ind = ind;

        if ( leftChildIdx < nums.length && nums[leftChildIdx] < nums[smallest_ind]){
            smallest_ind = leftChildIdx;
        }
        if ( rightChildIdx < nums.length && nums[rightChildIdx] < nums[smallest_ind]){
            smallest_ind = rightChildIdx;
        }
        if ( smallest_ind != ind){
            int temp = nums[smallest_ind];
            nums[smallest_ind] = nums[ind];
            nums[ind] = temp;
            heapifyDown(nums, smallest_ind);
        }
    }

    private void heapifyUp(int[] nums, int ind) {
        int parent = (ind-1)/2;
        if ( ind > 0){
            if ( nums[ind] < nums[parent]){
                int temp = nums[ind];
                nums[ind] = nums[parent];
                nums[parent] = temp;
                heapifyUp(nums, parent);
            }
        }
    }
}
