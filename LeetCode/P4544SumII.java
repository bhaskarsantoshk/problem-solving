package LeetCode;

import java.util.HashMap;

public class P4544SumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int sum= A[i]+B[j];
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        int count=0;
        for(int i=0; i<C.length;i++){
            for(int j=0; j<D.length; j++){
                int sum = -1 * (C[i]+D[j]);
                if(map.containsKey(sum)){
                    count+=map.get(sum);
                }
            }
        }
        return count;
    }
}
