package company.google;

import company.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}
