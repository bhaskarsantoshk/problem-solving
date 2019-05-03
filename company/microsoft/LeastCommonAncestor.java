package microsoft;

public class LeastCommonAncestor {
    static int b, c;
    public int lca(TreeNode A, int B, int C) {
        b=0;
        c=0;

        TreeNode result = helper(A, B, C);
        int a;
        if(b==0 || c==0){
            return -1;
        }
        if(result== null){
            a=-1;
        }
        else{
            a= result.val;
        }

        return a;

    }

    private TreeNode helper(TreeNode root, int B, int C) {
        if(root== null){
            return  null;
        }
        TreeNode left = helper(root.left, B, C);
        TreeNode right = helper(root.right, B , C);
        if(root.val == B){
            b=1;
        }
        if(root.val == C){
            c=1;
        }

        if(root.val == B || root.val== C){
            return root;
        }
        if(left!= null && right!= null){
            return  root;
        }
        if(left == null && right== null){
            return null;
        }
        return left!=null ? left: right;
    }
}
