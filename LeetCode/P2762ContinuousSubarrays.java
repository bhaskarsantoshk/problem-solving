package LeetCode;

public class P2762ContinuousSubarrays {
    public long continuousSubarrays(int[] nums) {
        long result = 0;
        int left =0, right = 0;
        int curMax , curMin;
        curMin = curMax = nums[0];
        long windowLen = 0;
        for ( right =0; right <nums.length; right++) {
            curMin = Math.min(curMin, nums[right]);
            curMax = Math.max(curMax, nums[right]);

            if (curMax - curMin > 2) {
                windowLen = right - left;
                result += (windowLen * (windowLen + 1)) / 2;

                left = right;
                while (left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2) {
                    left--;
                    curMax = Math.max(curMax, nums[left]);
                    curMin = Math.min(curMin, nums[right]);
                }

                if (left < right) {
                    windowLen = right - left;
                    result -= (windowLen * (windowLen + 1)) / 2;
                }
            }
        }
        windowLen = right-left;
        result += (windowLen* (windowLen+1))/2;
        return result;
    }
}
