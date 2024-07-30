package company.google.arrays;

import java.util.*;

public class P857MinimumCostToHireKWorkers {
    public double mincostToHireWorkersBruteForce(int[] quality, int[] wage, int k) {
        double totalMinimumCost = Double.MAX_VALUE;
        // Fix one worker and pay rest accordingly and calculate the cost
        for ( int i=0; i<quality.length; i++){
            // Fix i
            List<Double> cost = new ArrayList<>();
            double ratio = (double) wage[i]/quality[i];
            for ( int j=0; j<quality.length; j++){
                double workerPay = (double) ratio * quality[j];
                if ( workerPay < wage[j]) continue;
                cost.add(workerPay);
            }
            if ( cost.size() < k) continue;

            Collections.sort(cost);
            double tempCost = 0;
            for ( int index=0; index<k; index++){
                tempCost += cost.get(index);
            }
            totalMinimumCost = Math.min(totalMinimumCost, tempCost);
        }
        return totalMinimumCost;
    }

    public double mincostToHireWorkersUsingPriorityQueue(int[] quality, int[] wage, int k) {
        double totalMinimumCost = Double.MAX_VALUE;
        // Fix one worker and pay rest accordingly and calculate the cost
        for ( int i=0; i<quality.length; i++){
            // Fix i
            PriorityQueue<Double> cost = new PriorityQueue<>((a,b)-> Double.compare(b,a));
            double ratio = (double) wage[i]/quality[i];
            for ( int j=0; j<quality.length; j++){
                double workerPay = (double) ratio * quality[j];
                if ( workerPay < wage[j]) continue;
                cost.add(workerPay);
                if ( cost.size() > k) cost.poll();
            }
            if ( cost.size() < k) continue;
            double tempCost = 0;
            for ( int index=0; index<k; index++){
                tempCost += cost.poll();
            }
            totalMinimumCost = Math.min(totalMinimumCost, tempCost);
        }
        return totalMinimumCost;
    }

    public double mincostToHireWorkersOptimized(int[] quality, int[] wage, int k) {
        double[][] workers = new double[quality.length][2];
        for ( int i=0; i<quality.length; i++){
            workers[i][0] = (double) wage[i]/quality[i];
            workers[i][1] = (double) quality[i];
        }

        Arrays.sort(workers, (a,b)->Double.compare(a[0], b[0]));
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)->(int)(b-a));
        double res= Double.MAX_VALUE, qsum = 0;
        for ( double[] w: workers){
            qsum += w[1];
            pq.offer(w[1]);
            if ( pq.size() > k){
                qsum -= pq.poll();
            }
            if ( pq.size() == k){
                res = Math.min(res, qsum * w[0]);
            }
        }
        return res;
    }


    class Worker{
        int quality;
        int wage;
        double ratio;

        Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for ( int i=0; i<n; i++){
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a,b)-> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        int qualitySum = 0;
        double minCost = Double.MAX_VALUE;
        for ( Worker worker: workers){
            maxHeap.offer(worker.quality);
            qualitySum += worker.quality;

            if ( maxHeap.size() > k) qualitySum -= maxHeap.poll();
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, qualitySum * worker.ratio);
            }
        }
        return minCost;
    }
}
