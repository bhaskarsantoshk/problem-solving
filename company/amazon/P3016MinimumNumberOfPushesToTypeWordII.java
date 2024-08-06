package company.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P3016MinimumNumberOfPushesToTypeWordII {
    public int minimumPushes(String word) {
        int[] frequency = new int[26];
        for ( char c: word.toCharArray()) frequency[c-'a']++;

        // Sort frequencies in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int freq : frequency) {
            if (freq > 0) {
                pq.offer(freq);
            }
        }

        int count =0;
        int res = 0;
        while (!pq.isEmpty()) {
            int freq = pq.poll();
            count++;
            res += freq * ( 1+ (count-1)/8);
        }

        return res;
    }
}
