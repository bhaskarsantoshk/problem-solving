package takeUForward.greedy.revision;

import java.util.Arrays;

public class P10MinimumNumberOfPlatforms {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);
        int i=0, j=0;
        int count = 0;
        int max = 0;
        while ( i <n && j < n){
            if ( at[i] <= dt[j]){
                count++;
                i++;
            } else {
                j++;
                count--;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
