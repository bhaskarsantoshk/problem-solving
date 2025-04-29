package takeUForward.binaryTrees;

import takeUForward.trees.Inorder;
import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P2CheckIfTwoTreesAreIdenticalOrNot {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null && q == null) return true;
        if ( p == null || q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIterative(TreeNode p, TreeNode q) {
        TreeNode pNode = p;
        TreeNode qNode = q;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(pNode);
        stack.push(qNode);
        while (!stack.isEmpty()){
            pNode = stack.pop();
            qNode = stack.pop();
            if ( pNode == null && qNode == null) continue;
            if ( pNode == null || qNode == null || pNode.val != qNode.val ) return false;
            stack.push(pNode.left);
            stack.push(qNode.left);
            stack.push(pNode.right);
            stack.push(qNode.right);
        }
        return true;
    }
}
