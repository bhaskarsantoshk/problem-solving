package LeetCode;

public class P783MinimumDistanceBetweenBSTNodes {
    Integer result = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root.left != null ){
            minDiffInBST(root.left);
        }
        if(pre != null ){
            result = Math.min(result, root.val - pre);
        }
        pre = root.val;
        if(root.right != null){
            minDiffInBST(root.right);
        }
        return result;
    }
}
