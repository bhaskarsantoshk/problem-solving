package takeUForward.greedy.revision;

public class P3SJF {
    public static int minAverageWaitTimeUsingShortestJobFirst(int[] jobs){
        int waitTime = 0;
        int timeTillCompletion = 0;
        for ( int job: jobs){
            waitTime += timeTillCompletion;
            timeTillCompletion += waitTime;
        }
        return timeTillCompletion/jobs.length;
    }
}
