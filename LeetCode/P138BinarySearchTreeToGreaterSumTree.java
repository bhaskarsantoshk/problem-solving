package LeetCode;

public class P138BinarySearchTreeToGreaterSumTree {
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if ( root.right != null ) {
            bstToGst(root.right);
        }
        pre = root.val = pre + root.val;
        if ( root.left != null ) {
            bstToGst(root.left);
        }
        return root;
    }

   class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
       TreeNode(int val) { this.val = val; }
       TreeNode() {}
       TreeNode(int x, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
   }

}
