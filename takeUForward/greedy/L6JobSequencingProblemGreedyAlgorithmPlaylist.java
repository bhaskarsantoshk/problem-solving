package takeUForward.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class L6JobSequencingProblemGreedyAlgorithmPlaylist {
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit-o1.profit;
            }
        });

        int count = 0;
        int profit = 0;
        int maxDeadline = -1;
        for ( Job job: arr){
            maxDeadline = Math.max( maxDeadline, job.deadline);
        }
        int [] days = new int[maxDeadline+1];
        Arrays.fill(days, -1);
        for ( Job job: arr ){
            int deadline = job.deadline;
            while ( deadline > 0 && days[deadline] != -1){
                deadline--;
            }
            if ( deadline > 0 && days[deadline] == -1){
                days[deadline] = job.id;
                profit += job.profit;
            }
        }
        return days;
    }

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
}
