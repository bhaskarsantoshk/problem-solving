package takeUForward.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MorrisInorderTraversal {
    public static List< Integer > getInOrderTraversal(TreeNode root) {
       List<Integer> result = new ArrayList<>();
       TreeNode node = root;
       Stack<TreeNode> stack = new Stack<>();
       while ( node != null || !stack.isEmpty()){
           if ( node != null){
               stack.push(node);
               node = node.left;
           } else {
               node = stack.pop();
               result.add(node.val);
               node = node.right;
           }
       }
       return result;
    }

    public static List< Integer > getMorrisInOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode node = root;
        while ( node != null ){
            if ( node.left == null){
                result.add(node.val);
                node = node.right;
            } else {
                TreeNode prev = node.left;
                while ( prev.right != null && prev.right != node){
                    prev = prev.right;
                }
                if ( prev.right == null){
                    prev.right = node;
                    node = node.left;
                } else {
                    prev.right = null;
                    result.add(node.val);
                    node = node.right;
                }
            }
        }
        return result;
    }
}
