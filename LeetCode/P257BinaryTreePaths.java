package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root != null ) backtrack(root,"", result);
        return result;
    }

    private void backtrack(TreeNode root, String path, List<String> result) {
       if( root.left == null && root.right == null ){
           result.add(path+root.val);
       }
       if(root.left != null){
           backtrack(root.left, path+root.val+"->",result);
       }
        if(root.right != null){
            backtrack(root.right, path+root.val+"->",result);
        }
    }
}
