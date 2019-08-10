package LeetCode;

public class P31NextPermutation {
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        for ( int i=0; i< nums.length-1; i++){
            if ( nums[i] < nums[i+1]){
                index1 = i;
            }
        }
        if ( index1 == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int index2 = nums.length-1;
        while ( index2 > index1 ){
            if ( nums[index2] > nums[index1] ){
                break;
            }
            index2--;
        }
        swap(nums, index1, index2);
        reverse(nums, index1+1, nums.length-1);
    }
    private void swap ( int[] nums, int i, int j){
        int temp= nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int start, int end){
        while ( start < end ){
            swap(nums, start++, end--);
        }
    }
}
