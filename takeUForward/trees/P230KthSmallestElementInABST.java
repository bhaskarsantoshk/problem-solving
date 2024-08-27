package takeUForward.trees;

import java.util.Stack;

public class P230KthSmallestElementInABST {
    // Use Morris Traversal
    // if the problem is about kth largest - count number of nodes and find out n-kth in next traversal
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while ( node != null || !stack.isEmpty()){
            if ( node != null) {
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.pop();
                if ( --k == 0) return node.val;
                node = node.right;
            }
        }
        return -1;
    }

    // Remember two use cases
    // 1. if node.left == null , that node gets into result, node = node.right
    // 2. if node.left not null, keep the prev ( node.left), go to extreme right and attach it's right to node
    public int kthSmallestUsingMorrisTraversal(TreeNode root, int k) {
        TreeNode node = root;
        while ( node != null){
            if ( node.left == null){
                if ( --k == 0) return node.val;
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
                    if ( --k == 0) return node.val;
                    node = node.right;
                }
            }
        }
        return -1;
    }
}
