package LeetCode;

public class P3191MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    public int minOperations(int[] nums) {
        int count = 0;
        for ( int i=0; i<nums.length; i++){
            if ( nums[i] == 0 && i < nums.length - 2 ){
                nums[i] = ( nums[i] == 0 ) ? 1 : 0;
                nums[i+1] = ( nums[i+1] == 0 ) ? 1 : 0;
                nums[i+2] = ( nums[i+2] == 0 ) ? 1 : 0;
                count++;
            }
        }
        if ( nums[nums.length-1] == 0 || nums[nums.length-2] == 0 ){
            return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        P3191MinimumOperationsToMakeBinaryArrayElementsEqualToOneI solution = new P3191MinimumOperationsToMakeBinaryArrayElementsEqualToOneI();
        System.out.println(solution.minOperations(new int[]{0,1,1,1,0,0}));
    }
}
