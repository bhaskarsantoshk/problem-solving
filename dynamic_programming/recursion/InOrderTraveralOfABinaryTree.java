package dynamic_programming.recursion;

public class InOrderTraveralOfABinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return ;
        }
        if(root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.val+" ");
        if(root.right != null) {
            inOrder(root.right);
        }
    }

    public static void main(String[] args){

    }
}
