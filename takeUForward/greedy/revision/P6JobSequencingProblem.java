package takeUForward.greedy.revision;

import java.util.Arrays;

public class P6JobSequencingProblem {
    public static int[] jobScheduling(int [][]jobs) {
        Arrays.sort(jobs, (job1,job2)-> Integer.compare(job2[2], job1[2]));
        int maxDeadline = 0;
        for ( int i=0; i<jobs.length; i++){
            maxDeadline = Math.max(maxDeadline, jobs[i][1]);
        }
        int[] slots = new int[maxDeadline+1];
        Arrays.fill(slots, -1);
        int totalProfit = 0;
        int count = 0;
        for ( int[] job: jobs){
            for ( int j=job[1]; j>0; j--){
                if ( slots[j] == -1){
                    totalProfit += job[2];
                    count++;
                    slots[j] = job[0];
                    break;
                }
            }
        }
        return new int[]{count, totalProfit};
    }
}
