package company.microsoft;

import java.util.ArrayList;
import java.util.List;

public class P99RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder( root, list);

        int x = Integer.MIN_VALUE, y = Integer.MIN_VALUE;
        for ( int i=0; i<list.size()-1; i++){
            if ( list.get(i) > list.get(i+1) ){
                if ( x == Integer.MIN_VALUE) x = list.get(i);
                y = list.get(i+1);
            }
        }

        int[] swapped = new int[] {x,y};
        recover(root, 2, swapped[0], swapped[1]);
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


}
