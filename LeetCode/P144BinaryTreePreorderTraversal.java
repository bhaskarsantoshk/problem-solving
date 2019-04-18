package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P144BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left != null){
            preOrder(root.left, list);
        }
        if(root.right != null){
            preOrder(root.right, list);
        }
    }
}
