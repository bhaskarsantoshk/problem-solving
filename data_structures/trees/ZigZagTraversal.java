package data_structures.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversal {
    public static List<List<Integer>> zigZagTraverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        if ( root == null ) return result;
        boolean leftToRight = true;
        int level = 0;
        currentLevel.push(root);
        result.add(new ArrayList<>());
        while ( !currentLevel.isEmpty() ){
            TreeNode node = currentLevel.pop();
            result.get(level).add(node.data);
            if ( leftToRight ){
                if ( node.left != null ){
                    nextLevel.push(node.left);
                }
                if ( node.right != null ){
                    nextLevel.push(node.right);
                }
            } else {
                if ( node.right != null ){
                    nextLevel.push(node.right);
                }
                if ( node.left != null ){
                    nextLevel.push(node.left);
                }
            }
            if (currentLevel.isEmpty() ){
                Stack temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
                nextLevel = null;
                leftToRight = !leftToRight;
                result.add(new ArrayList<>());
                level++;
            }
        }
        result.remove(result.size()-1);
        return result;
    }
}
