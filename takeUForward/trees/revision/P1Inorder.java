package takeUForward.trees.revision;
import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class P1Inorder {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if ( root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
