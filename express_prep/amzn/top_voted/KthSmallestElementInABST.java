package express_prep.amzn.top_voted;

import data_structures.stacks_and_queues.Stack;

public class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if ( root == null || k == 0) return -1;
        Stack<TreeNode> stack = new Stack<>();
        while ( root != null || !stack.isEmpty() ){
            while ( root != null ){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if ( --k == 0) break;;
            root = root.right;
        }
        return root.val;
    }
}
