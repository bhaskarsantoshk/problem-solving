package LeetCode;

public class P922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int i=0, j=1;
        int len = nums.length;
        while ( i< len && j < len ){
            while ( i < len && nums[i] % 2== 0){
                i+=2;
            }
            while ( j < len && nums[j] % 2 == 1){
                j+=2;
            }

            if ( i < len && j < len ){
                swap(nums, i, j);
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
