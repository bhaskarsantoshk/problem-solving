package company.microsoft.revision;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P99RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int x=Integer.MIN_VALUE, y = Integer.MIN_VALUE;
        for (int i=0; i<list.size()-1; i++){
            if ( list.get(i+1) < list.get(i)){
                if ( x == Integer.MIN_VALUE) x = list.get(i);
                y = list.get(i+1);
            }
        }
        recover(root, 2, x, y);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if ( root == null) return;
        if ( root.val == x || root.val == y){
            root.val = ( root.val == x) ? y: x;
            if ( --count == 0) return;
        }
        recover(root.left, count, x, y);
        recover(root.right, count, x, y);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if ( root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }



    public void recoverTree2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pred= null, first=null, second=null;
        while ( !stack.isEmpty()  || root != null){
            while ( root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.poll();
            // data
            if ( pred != null && pred.val > root.val){
                if ( first == null) first = pred;
                second = root;
            }
            pred = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
