package takeUForward.trees;

import java.util.ArrayList;

public class CheckIfPathExists {

    public ArrayList<Integer> checkIfPathExists(TreeNode root, int node){
        ArrayList<Integer> path = new ArrayList<>();
        if ( root == null ) return path;
        getPath(root, path, node);
        return path;
    }
    public boolean getPath(TreeNode root, ArrayList<Integer> arr, int x){
        if ( root == null) return false;
        arr.add(root.val);
        if ( root.val == x) return true;
        if ( getPath(root.left, arr, x) || getPath(root.right, arr, x)) return true;
        arr.removeLast();
        return false;
    }
}
