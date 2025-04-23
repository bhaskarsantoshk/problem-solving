package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P2PreorderTraversal {
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode root, List<Integer> res) {
        if ( root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }
}
