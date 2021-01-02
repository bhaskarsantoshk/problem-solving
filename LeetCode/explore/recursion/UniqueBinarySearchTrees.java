package Leetcode.explore.recursion;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
          }
        return generateTrees(1,n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end){
            result.add(null);
            return result;
        }

        if (start == end){
            result.add(new TreeNode(start));
            return result;
        }
        List<TreeNode> left, right;
        for ( int i = start  ; i<=end; i++){
            left = generateTrees(start, i-1);
            right = generateTrees(i+1, end);
            for ( TreeNode lNode: left ){
                for ( TreeNode rNode : right ){
                    TreeNode root = new TreeNode(i);
                    root.left = lNode;
                    root.right = rNode;
                    result.add(root);
                }
            }
        }
        return result;
    }
}