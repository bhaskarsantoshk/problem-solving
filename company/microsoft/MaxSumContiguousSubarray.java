package company.microsoft;

import java.util.List;

public class MaxSumContiguousSubarray {
    public int maxSubArray(final List<Integer> a) {
        int localMax = a.get(0);
        int globalMax = a.get(0);
        for(int i=1; i<a.size(); i++){
            localMax = Math.max(localMax+ a.get(i), a.get(i));
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
