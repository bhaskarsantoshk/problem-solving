package standard_algorithms;


import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversalofaBinaryTree {
    public List<Integer> boundaryOfBinaryTree (TreeNode root){
      List<Integer> result = new ArrayList<>();
      if ( root == null ){
          return result;
      }
      if ( root.left != null || root.right != null ){
          result.add(root.val);
      }
      leftBoundary(root.left, result);
      leaves(root, result);
      rightBoundary(root.right, result);
      return result;
    }

    private void leaves(TreeNode root, List<Integer> result) {
        if ( root == null ){
            return;
        }
        if ( root.left == null && root.right == null ){
            result.add(root.val);
        }
        leaves(root.left, result);
        leaves(root.right, result);
    }

    private void leftBoundary(TreeNode node, List<Integer> result) {
        if ( node == null || (node.left == null && node.right== null )){
            return;
        }
        result.add(node.val);
        if ( node.left == null ){
            leftBoundary(node.right, result);
        }
        else{
            leftBoundary(node.left, result);
        }
    }

    private void rightBoundary(TreeNode node, List<Integer> result) {
        if ( node == null  || (node.left== null && node.right== null)){
            return;
        }
        if ( node.right == null ){
            rightBoundary(node.left, result);
        }
        else{
            rightBoundary(node.right, result);
        }
        result.add(node.val);
    }


    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode( int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
