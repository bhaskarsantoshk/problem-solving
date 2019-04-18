package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P145BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    private void postOrder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.left != null){
            postOrder(root.left, list);
        }
        if(root.right != null){
            postOrder(root.right, list);
        }
        list.add(root.val);

    }
}
