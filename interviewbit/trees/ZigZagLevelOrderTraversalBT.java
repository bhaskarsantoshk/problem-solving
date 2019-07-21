package interviewbit.trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrderTraversalBT {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> currentList = new Stack<>();
        Stack<TreeNode> nextList = new Stack<>();
        boolean leftToRight = false;
        int level =0;
        result.add(new ArrayList<>());
        while ( !currentList.isEmpty()){
            TreeNode popped = currentList.pop();
            result.get(level).add(popped.val);
            if ( leftToRight ){
                if ( popped.left != null ){
                    nextList.push(popped.left);
                }
                if ( popped.right != null ){
                    nextList.push(popped.right);
                }
            }
            else{
                if ( popped.right != null ){
                    nextList.push(popped.right);
                }
                if ( popped.left != null ){
                    nextList.push(popped.left);
                }
            }

            if ( currentList.isEmpty() ){
                level++;
                result.add(new ArrayList<>());
                currentList = nextList;
                nextList= null;
                leftToRight = !leftToRight;
            }
        }
        return result;
    }
}
