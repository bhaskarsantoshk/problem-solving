package microsoft;

import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lis(final List<Integer> A) {
        if(A.size()==0 || A.size()==1){
            return A.size();
        }
        int result[] = new int[A.size()];
        int maxLen = 1;
        Arrays.fill(result, 1);
        for(int i=1;i<A.size(); i++){
            for(int j=0; j<=i; j++){
                if(A.get(i)> A.get(j) && result[i] < result[j]+1){
                    result[i] = result[j] + 1;
                    maxLen = Math.max(maxLen, result[i]);
                }
            }
        }
        return maxLen;
    }
}
