package takeUForward.trees.revision;

import java.util.Stack;
import takeUForward.trees.TreeNode;

public class P14CheckForSymmetricalBTs {
    public boolean isSymmetric(TreeNode root) {
       if ( root == null) return true;
       return isSameTree(root.left, root.right);
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if ( s == null && t == null) return true;
        if ( s == null || t == null || s.val != t.val) return false;
        return isSameTree(s.left, t.right) && isSameTree(s.right, t.left);
    }

    private boolean isSameTreeIterative(TreeNode s, TreeNode t) {
       Stack<TreeNode> stack = new Stack<>();
       stack.push(s);
       stack.push(t);
       while ( !stack.isEmpty()){
           TreeNode sNode = stack.pop();
           TreeNode tNode = stack.pop();
           if ( sNode == null && tNode == null) continue;
           if ( sNode == null || tNode == null || sNode.val != tNode.val ) return false;
           stack.push(sNode.left);
           stack.push(tNode.right);
           stack.push(sNode.right);
           stack.push(tNode.left);
       }
       return true;
    }
}
