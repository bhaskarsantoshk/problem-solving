package takeUForward.QR;

import java.util.ArrayList;
import java.util.List;

public class P7ReversePairs {
    public int reversePairsBruteForce(int[] nums) {
        int count = 0;
        int n = nums.length;
        for ( int i=0; i<n; i++){
            for ( int j=i+1; j<n; j++){
                if ( nums[i] > 2 * nums[j]) count++;
            }
        }
        return count;
    }

    public int reversePairs(int[] nums) {
        int start = 0, end = nums.length-1;
        return mergeSort(nums, start, end);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if ( start >= end) return 0;
        int mid = (start+end)/2;
        int count = 0;
        count += mergeSort(nums, start, mid);
        count += mergeSort(nums, mid+1, end);
        count += countPairs(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }
    private int countPairs(int[] nums, int low, int mid, int high) {
        int right = mid + 1, cnt = 0;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) {
                right++;
            }
            cnt += (right - (mid + 1));
        }

        return cnt;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }

        while (left <= mid) temp.add(nums[left++]);
        while (right <= high) temp.add(nums[right++]);

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }
}
