package company.microsoft;


import java.util.Stack;

public class P98ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, prev = null;
        while ( cur != null || !stack.isEmpty()){
            if ( cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if ( prev != null && prev.val > cur.val) return false;
                prev = cur;
                cur = cur.right;
            }
        }

        return true;
    }

    public boolean isValidBSTRecursive(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if ( root == null) return true;
        if ( root.val <= minValue || root.val >= maxValue) return false;
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
    }
}
