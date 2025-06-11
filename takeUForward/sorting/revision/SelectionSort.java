package takeUForward.sorting.revision;

public class SelectionSort {
    public int[] selectionSort(int [] nums){
        int n = nums.length;
        for ( int i=0; i<n; i++){
            int minIndex = i;
            for ( int j=i; j<n; j++){
                if ( nums[j] < nums[minIndex]) minIndex = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }
}
