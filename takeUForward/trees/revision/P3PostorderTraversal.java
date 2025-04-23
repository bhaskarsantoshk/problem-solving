package takeUForward.trees.revision;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P3PostorderTraversal {
    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if ( root == null) return;
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
