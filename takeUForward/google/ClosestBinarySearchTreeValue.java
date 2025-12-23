package takeUForward.google;

public class ClosestBinarySearchTreeValue {
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }


    public int closestValue(TreeNode root, double target) {
        int [] res = new int[1];
        double [] diff = new double[1];
        res[0] = -1;
        diff[0] = Double.MAX_VALUE;
        helper(root, target, res, diff);
        return res[0];
    }

    private void helper(TreeNode root, double target, int[] res, double[] diff) {
       if ( root == null) return ;
       if ( root.val == target) {
           res[0] = (int) target;
           return;
       }
       if ( diff[0] >= Math.abs(root.val - target)){
           diff[0] = Math.abs(root.val - target);
           res[0] = Math.min(res[0], root.val);
       }
       helper(root.left, target, res, diff);
        helper(root.right, target, res, diff);
    }

    public int closestValueOptimal(TreeNode root, double target) {
        int closestValue = root.val;
        while ( root != null ){
            if (Math.abs(root.val-target) < Math.abs(closestValue-target)){
                closestValue = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        return closestValue;
    }
}
