package LeetCode;

public class P100SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p== null || q== null ){
            return p== null && q== null;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
