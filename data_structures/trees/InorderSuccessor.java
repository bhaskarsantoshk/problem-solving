package data_structures.trees;

public class InorderSuccessor {
    public static TreeNode inorderSuccessor(TreeNode root, int val){
        if ( root == null ){
            return null;
        }
        TreeNode successor = null;
        while ( root != null ){
            if ( root.data < val ){
                root = root.right;
            } else if ( root.data > val ){
                root = root.left;
            } else{
                if ( root.right != null ){
                    successor = getMin(root.right);
                }
                break;
            }
        }
        return successor;
    }

    private static TreeNode getMin(TreeNode root) {
        if(root == null)
            return null;

        while(root.left != null) {
            root = root.left;
        }
        return root;
    }
}
