package company.amazon;

public class P171AverageWaitingTime {
    public double averageWaitingTime(int[][] customers) {
        long waitTime = 0, busyUptill = 0;
        int n = customers.length;
        for ( int i=0; i<n; i++){
            int arrival = customers[i][0], time = customers[i][1];
            waitTime += (Math.max(arrival, busyUptill ) + time - arrival);
            busyUptill = Math.max(arrival, busyUptill) + time;
        }
        return (double) waitTime /n;
    }
}
