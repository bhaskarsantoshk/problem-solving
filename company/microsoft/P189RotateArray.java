package company.microsoft;

public class P189RotateArray {
    public void rotateBruteForce(int[] nums, int k) {
        int n = nums.length;
        while ( k-- != 0){
            int last = nums[n-1];
            for ( int i=n-1; i>0; i--)  nums[i] = nums[i-1];
            nums[0] = last;
        }
    }

    /*

    Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

     */

    /*
    observations:
    reverse whole
    7 6 5 4 3 2 1
    reverse first k
    reverse  k to n
     */

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse (nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    private void reverse(int[] nums, int start, int end) {
        while ( start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
