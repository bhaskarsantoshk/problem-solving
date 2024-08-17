package takeUForward.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P545BoundaryOfBinaryTree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (!isLeaf(root)) res.add(root.val);
        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundaryInReverse(root, res);
        return res;
    }

    private void addRightBoundaryInReverse(TreeNode node, List<Integer> res) {
        node = node.right;
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            addLeaves(root.left, res);
            addLeaves(root.right, res);
        }
    }

    private void addLeftBoundary(TreeNode node, List<Integer> res) {
        node = node.left;
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
