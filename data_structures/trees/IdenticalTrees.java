package data_structures.trees;

public class IdenticalTrees {
    public boolean checkIfIdentical(TreeNode s, TreeNode t){
        if ( s== null && t==null) return true;
        if ( s == null || t== null) return false;
        return s.data==t.data &&
                checkIfIdentical(s.left, t.left) &&
                checkIfIdentical(s.right, t.right);
    }
}
