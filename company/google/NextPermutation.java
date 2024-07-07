package company.google;

public class NextPermutation {
    public void nextPermutation(int[] nums){
        int breakPoint = -1;
        for ( int i=nums.length-2; i>=0; i--){
            if ( nums[i] < nums[i+1]){
                breakPoint = i;
                break;
            }
        }
        if ( breakPoint != -1 ){
            for ( int i=nums.length-1; i>breakPoint ; i-- ){
                if ( nums[i] > nums[breakPoint] ){
                    swap(nums, i, breakPoint);
                    break;
                }
            }
        }
        reverse(nums, breakPoint+1, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while ( start < end ){
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
