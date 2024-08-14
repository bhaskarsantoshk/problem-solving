package company.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class P719FindKThSmallestPairDistance {
    public int smallestDistancePairNaive(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((b, a) -> Integer.compare(Math.abs(a[0] - a[1]), Math.abs(b[0] - b[1])));
        for ( int i=0; i<nums.length; i++){
            for ( int j=i+1; j<nums.length; j++){
                pq.offer(new int[]{nums[i], nums[j]});
                if ( pq.size() > k) pq.poll();
            }
        }
        int ans [] = pq.poll();
        return Math.abs(ans[0]-ans[1]);
    }


    public int smallestDistancePair(int[] nums, int k) {
        // NOTE: must sort the input array first so elements are in order
        Arrays.sort(nums);

        int maxDist = nums[nums.length - 1];

        // binary search on the distance
        int start = 0, end = maxDist + 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int num = numsOfSmallerDist(nums, mid);
            if (num >= k) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    // count the number of absolute distances that are no greater than val
    private int numsOfSmallerDist(int[] nums, int dist) {
        // a montone increasing queue
        Deque<Integer> queue = new ArrayDeque<>();
        int ans = 0;

        for (int num : nums) {
            while (!queue.isEmpty() && num - queue.peekFirst() > dist) {
                queue.removeFirst();
                ans += queue.size();
            }
            queue.addLast(num);
        }

        while (!queue.isEmpty()) {
            queue.removeFirst();
            ans += queue.size();
        }

        return ans;
    }
}
