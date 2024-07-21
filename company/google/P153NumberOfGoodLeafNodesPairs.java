package company.google;

import company.TreeNode;

import java.util.*;

public class P153NumberOfGoodLeafNodesPairs {
    int numOfGoodPairs;
    public int countPairs(TreeNode root, int distance) {
        numOfGoodPairs = 0;
        dfs( root, distance);
        return numOfGoodPairs;
    }

    private List<Integer> dfs(TreeNode root, int distance) {
        if ( root == null ) return new ArrayList<>();
        if ( root.left == null && root.right == null ) return new ArrayList<>(List.of(1));
        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs( root.right, distance);
        for ( int l : left){
            for ( int r : right ){
                if ( l + r <= distance ) {
                    numOfGoodPairs++;
                }
            }
        }
        List<Integer> parentList = new ArrayList<>();
        for ( int d : left){
            if (d+1 <= distance ) parentList.add(d+1);
        }
        for ( int d : right){
            if (d+1 <= distance ) parentList.add(d+1);
        }
        return parentList;
    }


    private Map<Integer, Integer> dfsOptimized(TreeNode root, int distance) {
        if ( root == null ) return new HashMap<>();
        if ( root.left == null && root.right == null ) return new HashMap<>(){{put(1,1);}};
        Map<Integer, Integer> left = dfsOptimized(root.left, distance);
        Map<Integer, Integer> right = dfsOptimized( root.right, distance);
        for ( int l : left.keySet()){
            for ( int r : right.keySet() ){
                if ( l + r <= distance ) {
                    numOfGoodPairs+= (left.get(l) * right.get(r));
                }
            }
        }
        Map<Integer, Integer> parentMap = new HashMap<>();
        for ( int d : left.keySet()){
            if (d+1 <= distance ) parentMap.put(d+1, parentMap.getOrDefault(d+1, 0)+left.get(d));
        }
        for ( int d : right.keySet()){
            if (d+1 <= distance ) parentMap.put(d+1, parentMap.getOrDefault(d+1, 0)+right.get(d));
        }
        return parentMap;
    }
}
