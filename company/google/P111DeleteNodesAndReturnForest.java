package company.google;
import company.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P111DeleteNodesAndReturnForest {
    Set<Integer> set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        res = new ArrayList<>();
        for ( int num: to_delete) set.add(num);
        helper(root, true);
        return res;
    }

    private TreeNode helper(TreeNode root, boolean is_root) {
        if ( root == null ) return null;
        boolean deleted = set.contains(root.val);
        if ( is_root && !deleted) res.add(root);
        root.left = helper(root.left, deleted);
        root.right = helper(root.right, deleted);
        return deleted ? null : root;
    }
}
