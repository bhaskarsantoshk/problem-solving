package takeUForward.trees;
import java.util.ArrayList;
import java.util.List;

public class P257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if ( root!= null ) preOrder(root, res, "");
        return res;
    }

    private void preOrder(TreeNode node, List<String> res, String path) {
        if ( node.left == null && node.right == null) {
            res.add(path+node.val);
        }
        if (node.left != null ) preOrder(node.left, res, path+node.val+"->");
        if (node.right != null ) preOrder(node.right, res, path+node.val+"->");
    }
}
