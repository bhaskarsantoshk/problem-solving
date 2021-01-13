package LeetCode.explore.arrays;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(3);
        Set<Integer> set = new HashSet<>();

        for ( int num: nums){
            if (!set.contains(num)){
                minHeap.offer(num);
                if ( minHeap.size() > 3){
                    set.remove(minHeap.poll());
                }
            }
            set.add(num);
        }
        if ( minHeap.size() < 3 ){
            while ( minHeap.size() > 1){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}