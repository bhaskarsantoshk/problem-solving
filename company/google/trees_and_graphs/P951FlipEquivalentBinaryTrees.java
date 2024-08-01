package company.google.trees_and_graphs;

import company.TreeNode;

public class P951FlipEquivalentBinaryTrees {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if ( root1 == null && root2 == null ) return true;
        if ( root1 == null || root2 == null || root1.val != root2.val ) return false;

        boolean firstCheck = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean secondCheck = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        return firstCheck || secondCheck;
    }
}
