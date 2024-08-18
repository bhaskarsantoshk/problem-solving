package takeUForward.trees;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfBinaryTree {
    ArrayList<Integer> leftView(TreeNode root) {
       ArrayList<Integer> result = new ArrayList<>();
       preOrder(root, result, 0);
       return result;
    }

    private void preOrder(TreeNode node, ArrayList<Integer> result, int level) {
        if ( node == null ) return;
        if ( result.size() == level ) result.add(node.val);
        if ( node.left != null ) preOrder(node.left, result, level+1);
        if ( node.right != null ) preOrder(node.right, result, level+1);
    }
}
