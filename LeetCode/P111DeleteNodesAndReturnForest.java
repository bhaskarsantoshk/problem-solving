package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P111DeleteNodesAndReturnForest {
    Set<Integer> set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet<>();
        res = new ArrayList<>();

        for ( int num: to_delete){
            set.add(num);
        }
        helper(root,true);
        return res;
    }

    private TreeNode helper(TreeNode node, boolean isroot){
        if ( node == null ) return null;
        boolean deleted = set.contains(node.val);
        if (isroot && !deleted){
            res.add(node);
        }
        node.left = helper(node.left, deleted);
        node.right = helper(node.right, deleted);
        return deleted ? null: node;
    }
}
