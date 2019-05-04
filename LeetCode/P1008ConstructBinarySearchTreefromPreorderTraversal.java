package LeetCode;

public class P1008ConstructBinarySearchTreefromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i=0; i<preorder.length ; i++){
                root = insertIntoBST(root, preorder[i]);
        }
        return root;
    }

    private TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            root = new TreeNode(val);
        }
        else if(root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        else{
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
    int index = 0;
    public TreeNode bstFromPreorderN(int a[]){
        return bstFromPreorderN(a, Integer.MAX_VALUE);
    }
    public TreeNode bstFromPreorderN(int[] a, int bound){
        if( index ==a.length || a[index] > bound ) return  null;
        TreeNode root = new TreeNode(a[index++]);
        root.left = bstFromPreorderN(a, root.val);
        root.right = bstFromPreorderN(a, bound);
        return root;
    }
}

