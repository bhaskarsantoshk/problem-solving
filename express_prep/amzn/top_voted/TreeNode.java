package express_prep.amzn.top_voted;

public class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode (){

    }
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
