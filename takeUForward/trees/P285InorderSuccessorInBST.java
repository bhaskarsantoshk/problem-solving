package takeUForward.trees;

public class P285InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode node = root;
        TreeNode successor = null;
        while ( node != null){
            if ( p.val >= node.val){
                node = node.right;
            } else {
                successor = node;
                node = node.left;
            }
        }
        return successor;
    }
}
