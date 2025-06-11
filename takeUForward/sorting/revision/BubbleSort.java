package takeUForward.sorting.revision;

public class BubbleSort {
    public int[] bubbleSort(int[] nums){
        int n = nums.length;
        for ( int i=n-1; i>=0; i--){
            for ( int j=0; j<=i-1; j++){
                if ( nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}
