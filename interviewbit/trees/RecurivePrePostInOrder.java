package interviewbit.trees;

import java.util.ArrayList;

public class RecurivePrePostInOrder {
    ArrayList<Integer> result = new ArrayList<>();
    public ArrayList<Integer> preOrder(TreeNode root){
        if (root!=null){
            helperPre(root);
        }
        return result;
    }

    private void helperPre(TreeNode root) {
        result.add(root.val);
        if(root.left != null) {
            helperPre(root.left);
        }
        if(root.right != null){
            helperPre(root.right);
        }
    }

    public ArrayList<Integer> inOrder(TreeNode root){
        if(root!=null){
            helperIn(root);
        }
        return result;
    }

    private void helperIn(TreeNode root) {
        if(root.left != null){
            helperIn(root.left);
        }
        result.add(root.val);
        if(root.right != null){
            helperIn(root.right);
        }
    }

    public ArrayList<Integer> postOrder(TreeNode root){
        if (root != null){
            helperPost(root);
        }
        return result;
    }

    private void helperPost(TreeNode root) {
        if(root.left != null){
            helperPost(root.left);
        }
        if(root.right != null){
            helperPost(root.right);
        }
        result.add(root.val);
    }
}
