package takeUForward.binarySearch;

import java.util.PriorityQueue;

public class MinimizeMaxDistanceToGasStationOptimized {
    public static double MinimiseMaxDistance(int []arr, int K){
        int n = arr.length;
        int[] howMany = new int[n];

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Double.compare(y.gap, x.gap));
        for ( int i=0; i<n-1; i++){
            Pair pair = new Pair(arr[i+1]-arr[i], i);
            pq.offer(pair);
        }

        for ( int gas=1; gas<=K; gas++){
            Pair tempPair = pq.poll();
            int index = tempPair.index;
            howMany[index]++;
            double initialDiff = arr[index+1]-arr[index];
            double newDiff = initialDiff/ (double)(howMany[index]+1);
            pq.offer(new Pair(newDiff, index));
        }
        return pq.poll().gap;

    }

    static class Pair{
        double gap;
        int index;

        Pair(double gap, int index){
            this.gap = gap;
            this.index = index;
        }
    }
}
