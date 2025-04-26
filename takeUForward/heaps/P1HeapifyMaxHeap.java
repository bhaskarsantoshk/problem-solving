package takeUForward.heaps;

public class P1HeapifyMaxHeap {
    public void heapifyMaxHeap(int[] nums, int ind, int val) {
        if (nums[ind] < val){
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
        int largest = ind;

        if ( leftChildIdx < nums.length && nums[leftChildIdx] > nums[largest]){
            largest = leftChildIdx;
        }
        if ( rightChildIdx < nums.length && nums[rightChildIdx] > nums[largest]){
            largest = rightChildIdx;
        }
        if ( largest != ind){
            int temp = nums[largest];
            nums[largest] = nums[ind];
            nums[ind] = temp;
            heapifyDown(nums, largest);
        }
    }

    private void heapifyUp(int[] nums, int ind) {
        int parent = (ind-1)/2;
        if ( ind > 0){
            if ( nums[ind] > nums[parent]){
                int temp = nums[ind];
                nums[ind] = nums[parent];
                nums[parent] = temp;
                heapifyUp(nums, parent);
            }
        }
    }
}
