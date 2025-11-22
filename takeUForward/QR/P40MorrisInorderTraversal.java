package takeUForward.QR;

import java.util.ArrayList;
import java.util.List;

public class P40MorrisInorderTraversal {
    public List<Integer> getInorder(TreeNode root) {
       List<Integer> inOrder = new ArrayList<>();
       TreeNode cur = root;
       while ( cur != null ){
           if ( cur.left == null) {
               inOrder.add(cur.data);
               cur = cur.right;
           } else {
               TreeNode prev = cur.left;
               while ( prev.right != null && prev.right != cur) prev = prev.right;
               if ( prev.right == null ) {
                   prev.right = cur;
                   cur = cur.left;
               } else {
                   prev.right = null;
                   inOrder.add(cur.data);
                   cur = cur.right;
               }
           }
       }
       return inOrder;
    }
}
