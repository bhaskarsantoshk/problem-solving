package microsoft;

import java.util.ArrayList;
import java.util.Collections;

public class RecoverBinarySearchTree {
    TreeNode firstStartPoint = null;
    TreeNode lastEndPoint = null;
    TreeNode previously_visited_Node = null;
    public ArrayList<Integer> recoverTree(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null){
            return null;
        }
        inorder(A);
        result.add(firstStartPoint.val);
        result.add(lastEndPoint.val);
        Collections.sort(result);
        return  result;
    }

    private void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        if(previously_visited_Node == null){
            previously_visited_Node = root;
        }
        else{
            if(root.val < previously_visited_Node.val){
                if(firstStartPoint == null){
                    firstStartPoint = previously_visited_Node;
                }
                lastEndPoint = root;
            }
            previously_visited_Node = root;
        }
        inorder(root.right);
    }
}
