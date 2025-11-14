package takeUForward.QR;

import java.util.Arrays;

public class P18JobSequencingProblem {
    public int[] JobScheduling(int[][] Jobs) {
        Arrays.sort(Jobs, (a,b)->b[2]-a[2]);
        int n = Jobs.length;
        int maxDeadline = 0;
        for ( int i=0; i<n; i++){
            maxDeadline = Math.max(maxDeadline, Jobs[i][1]);
        }
        int []hash = new int[maxDeadline];
        Arrays.fill(hash, -1);
        int count =0;
        int totalProfit = 0;
        for ( int i=0; i<n; i++){
            for ( int j=Jobs[i][1]-1; j>=0; j--){
                if ( hash[j] == -1){
                    count++;
                    hash[j] = Jobs[i][0];
                    totalProfit += Jobs[i][2];
                    break;
                }
            }
        }
        return new int[]{count, totalProfit};
    }
}
