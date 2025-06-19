package takeUForward.slidingWindow;

public class P3NumberOfSubarraysWithSumK {
    public int numSubarraysWithSum(int[] A, int k) {
        return numSubarraysWithMaxSumK(A, k) - numSubarraysWithMaxSumK(A, k - 1);
    }

    private int numSubarraysWithMaxSumK(int[] arr, int k) {
        int left =0, right =0;
        int sum =0;
        int result = 0;
        while ( right < arr.length){
            sum += arr[right];
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            result += (right - left + 1); // All subarrays ending at 'right' and starting from 'left' to 'right'
            right++;
        }
        return result;
    }
}
