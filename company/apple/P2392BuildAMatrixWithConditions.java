package company.apple;

import java.util.*;

public class P2392BuildAMatrixWithConditions {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = generateTopologicalOrder(rowConditions, k);
        List<Integer> colOrder = generateTopologicalOrder(colConditions, k);
        if ( rowOrder.size() < k || colOrder.size() < k) return new int[0][0];

        Map<Integer, Integer> colMap = new HashMap<>();
        for ( int i=0; i<k; i++) colMap.put(colOrder.get(i), i);
        int[][] matrix = new int[k][k];
        for ( int i=0; i<k; i++) matrix[i][colMap.get(rowOrder.get(i))] = rowOrder.get(i);
        return matrix;
    }

    private List<Integer> generateTopologicalOrder(int[][] arr, int k) {
        int [] degree = new int[k];
        List<Integer> order = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for ( int i=0; i<k ; i++) graph.add(new ArrayList<>());
        for ( int[] conn: arr){
            graph.get(conn[0]-1).add(conn[1]-1);
            degree[conn[1]-1]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for ( int i=0; i<k; i++){
            if ( degree[i] == 0) queue.offer(i);
        }
        while ( !queue.isEmpty()){
            int x = queue.poll();
            order.add(x+1);
            for ( int y: graph.get(x)){
                if ( --degree[y] == 0) queue.offer(y);
            }
        }
        return order;
    }
}
