package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> curLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<>();
        if(root == null){
            return result;
        }
        boolean leftToRight = true;
        result.add(new ArrayList<>());
        int level =0;
        curLevel.push(root);
        while( !curLevel.isEmpty()){
            TreeNode popped = curLevel.pop();
            result.get(0).add(popped.val);
            if(leftToRight){
                if(popped.left != null){
                    nextLevel.push(popped.left);
                }
                if(popped.right != null){
                    nextLevel.push(popped.right);
                }
            }
            else{
                if(popped.right != null){
                    nextLevel.push(popped.right);
                }
                if(popped.left != null){
                    nextLevel.push(popped.left);
                }
            }
            if(curLevel.isEmpty()){
                Stack temp = curLevel;
                curLevel = nextLevel;
                nextLevel = temp;
                nextLevel= null;
                leftToRight= !leftToRight;
                result.add(new ArrayList<>());
                level++;
            }
        }
        result.remove(result.size()-1);
        return result;
    }
}
