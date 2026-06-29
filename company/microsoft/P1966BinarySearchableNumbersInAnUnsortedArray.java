package company.microsoft;

public class P1966BinarySearchableNumbersInAnUnsortedArray {
    public int binarySearchableNumbers(int[] nums) {
        int n = nums.length;
        int []leftMax = new int[n];
        leftMax[0] = nums[0];
        for (int i=1; i<n; i++) leftMax[i] = Math.max(nums[i], leftMax[i-1]);
        int []rightMin = new int[n];
        rightMin[n-1] = nums[n-1];
        for (int i=n-2; i>=0; i--) rightMin[i] = Math.min(rightMin[i+1], nums[i]);
        int count = 0;
        for (int i=0; i<n; i++){
            boolean leftOk = (i==0) || nums[i] >= leftMax[i-1];
            boolean rightOk = (i==n-1) || nums[i] <= rightMin[i+1];

            if ( leftOk && rightOk) count++;
        }
        return count;
    }
}
