package company.google;

public class P1929ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];

        // 0 1 2 3 4 5 6 7
        for ( int i=0; i<ans.length; i++){
            if ( i < n) {
                ans[i] = nums[i];
            } else {
                ans[i] = nums[i%n];
            }
        }
        return ans;
    }

    public int[] getConcatenationOptimized(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2*n];

        for ( int i=0; i<n; i++){
            ans[i] = ans[i+n] = nums[i];
        }
        return ans;
    }
}
