package company.apple;

public class P18SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int [] merge = new int[nums.length];
        int index = 0;
        int i=0, j = nums.length-1;
        for ( index=nums.length-1; index>=0; index--){
            if ( Math.abs(nums[i]) > Math.abs(nums[j])) {
                merge[index] = nums[i]*nums[i];
                i++;
            } else {
                merge[index] = nums[j]* nums[j];
                j--;
            }
        }
        return merge;
    }
}
