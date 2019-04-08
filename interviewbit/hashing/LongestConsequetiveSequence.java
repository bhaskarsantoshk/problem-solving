package interviewbit.hashing;

import java.util.HashMap;
import java.util.List;

public class LongestConsequetiveSequence {
    public int longestConsecutive(final List<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0; i<A.size(); i++){
            int n = A.get(i);
            if(!map.containsKey(n)) {
                int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
                int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                res = Math.max(res, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else{
                continue;
            }

        }
        return res;
    }
}

//[100, 4, 200, 1, 3, 2]

// 100-1, 4-1, 200-1, 1-4, 3-4, 2-4
