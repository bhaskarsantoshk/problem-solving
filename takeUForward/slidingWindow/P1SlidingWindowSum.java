package takeUForward.slidingWindow;

public class P1SlidingWindowSum {
    public static int maxSumWindowK(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int l=0, r=0;
        while ( r < k){
            sum += arr[r];
            r++;
        }
        max = Math.max(max, sum);
        while ( r < n){
            sum -= arr[l];
            l++;
            sum += arr[r];
            r++;
            max = Math.max(max, sum);
        }
        return max;
    }
}
