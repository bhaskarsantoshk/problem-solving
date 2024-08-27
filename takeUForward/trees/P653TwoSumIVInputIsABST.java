package takeUForward.trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P653TwoSumIVInputIsABST {

    // Bruteforce , put inorder of BST in array and use two pointer

    public boolean findTarget(TreeNode root, int k) {
        if ( root == null) return false;
        BSTIterator l = new BSTIterator(root, false);
        BSTIterator r = new BSTIterator(root, true);

        int i = l.next();
        int j = r.next();
        while ( i < j){
            if ( i + j == k) return true;
            if ( i+j < k) i = l.next();
            else j = r.next();
        }
        return false;
    }

    class BSTIterator{
        Stack<TreeNode> stack = new Stack<>();
        boolean isReverse;

        public BSTIterator(TreeNode root, boolean isReverse){
            this.isReverse = isReverse;
            pushAll(root);
        }

        public boolean hasNext(){
            return !stack.isEmpty();
        }

        public int next(){
            TreeNode temp = stack.pop();
            if ( isReverse )pushAll(temp.left);
            else pushAll(temp.right);
            return temp.val;
        }

        private void pushAll(TreeNode root) {
            while ( root != null){
                stack.push(root);
                if ( isReverse){
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
    }

}
