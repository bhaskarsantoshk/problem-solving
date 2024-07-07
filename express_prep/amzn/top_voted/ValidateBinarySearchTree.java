package express_prep.amzn.top_voted;
import java.util.Stack;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        if ( root == null ) return false;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty() ){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( pre != null && pre.val >= root.val){
                return false;
            }
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBSTRec(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
        if ( root == null ) return true;
        if ( root.val >= maxValue || root.val <= minValue){
            return false;
        }
        return isValidBST(root.left, minValue, root.val) && isValidBST(root.right , root.val, maxValue);
    }
}
