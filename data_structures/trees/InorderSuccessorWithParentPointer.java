package data_structures.trees;

public class InorderSuccessorWithParentPointer {
    class TreeNode{
        int data;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
    }

    public static TreeNode getSuccessorBST(TreeNode root, int d){
        while ( root != null ){
            if ( root.data > d ){
                root = root.left;
            } else if ( root.data < d){
                root = root.right;
            } else {
                return inorderSuccessorBstParentPointer(root);
            }
        }
        return null;
    }
    public static TreeNode inorderSuccessorBstParentPointer(TreeNode node){
        if ( node == null ) return null;
        if ( node.right != null ){
            return getMin(node);
        }
        while ( node.parent != null ){
            if ( node.parent.left == node ){
                return node.parent;
            }
            node = node.parent;
        }
        return null;
    }

    private static TreeNode getMin(TreeNode node) {
        if ( node == null ) return null;
        while ( node.left != null ){
            node = node.left;
        }
        return node;
    }
}
