package company.google;

public class P912SortAnArray {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end) {
       if ( start < end){
           int mid = start + end -start/2;
           mergeSort(nums, start, mid);
           mergeSort(nums, mid+1, end);
           merge(nums, start, mid, end);
       }
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int left[] = new int[mid-start+1];
        int right[] = new int[end-mid];
        for ( int i=0; i<=left.length; i++){
            left[i] = nums[start+i];
        }
        for ( int i= 0; i<right.length; i++){
            right[i] = nums[mid+1+i];
        }

        int leftIndex=0, rightIndex=0;
        int index = start;
        while ( leftIndex < left.length && rightIndex < right.length ){
            if ( left[leftIndex] <= right[rightIndex]){
                nums[index++] = left[leftIndex++];
            } else {
                nums[index++] = right[rightIndex++];
            }
        }

        while ( leftIndex < left.length){
            nums[index++] = left[leftIndex++];
        }

        while ( rightIndex < right.length){
            nums[index++] = right[rightIndex++];
        }
    }
}
