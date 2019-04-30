package LeetCode;

public class P979DistributeCoinsinBinaryTree {
    private int steps = 0;
    public int distributeCoins(TreeNode root) {
        postorder(root);
        return steps;
    }
    private int postorder(TreeNode node) {
        if(node == null ){
            return 0;
        }
        int coin = postorder(node.left) + postorder(node.right);
        if(node.val == 0){
            coin+=-1;
        }
        else{
            coin+= node.val-1;
        }
        steps += Math.abs(coin);
        return coin;
    }
}
