package takeUForward.trees.revision3;

import books.EPI.BinaryTrees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversals {
    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val) {
            this.data = val;
            this.left = null;
            this.right = null;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    };

    public static List< Integer > getInOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if ( root == null ) return res;
        TreeNode node = root;
        while ( true ){
            if ( !stack.isEmpty() ){
                if ( node != null ) stack.push(node);
                node = node.left;
            } else {
                if ( stack.isEmpty() ) break;
                node = stack.pop();
                res.add(node.data);
                node = node.right;
            }
        }
        return res;
    }

    public static ArrayList<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
        
    }
}
