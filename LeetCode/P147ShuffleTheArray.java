package LeetCode;

public class P147ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int index = 0;
        for ( int i=0; i<n; i++){
            res[index++] = nums[i];
            res[index++] = nums[i+n];
        }
        return res;
    }
}
