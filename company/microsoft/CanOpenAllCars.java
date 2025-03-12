package company.microsoft;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanOpenAllCars {
    public boolean canOpenAllCars(int n, List<List<Integer>> keys){
        boolean[] vis = new boolean[n];
        vis[0] = true; // car(1) 1- 1 = 0
        Queue<Integer> q = new LinkedList<>();
        while ( !q.isEmpty()){
            int car = q.poll();
            for ( int key: keys.get(car-1)){
                if ( !vis[key]){
                    vis[key] = true;
                    q.offer(key);
                }
            }
        }
        int count = 0;
        for ( int i=0; i<n; i++){
            if ( vis[i] == true ) count++;
        }
        return count == n;
    }
}
