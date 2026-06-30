package company.microsoft;

public class P922SortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        int evenIndex = 0, oddIndex=1;
        int n = nums.length;
        while ( evenIndex < n && oddIndex < n){
            while ( evenIndex < n && nums[evenIndex] % 2 == 0) evenIndex+=2;
            while ( oddIndex < n && nums[oddIndex] % 2 == 1) oddIndex+= 2;
            if ( evenIndex < n && oddIndex < n){
                swap(nums, evenIndex, oddIndex);
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
