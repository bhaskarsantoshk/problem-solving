package takeUForward.trees;

public class CeilFromBST {
    public static int findCeil(TreeNode<Integer> node, int x) {
        TreeNode<Integer> cur = node;
        int ans = -1;
        while ( cur != null ){
            if (cur.data == x){
                return cur.data;
            }
            if (cur.data > x){
                ans = cur.data;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return ans;
    }

    class TreeNode<T>
    {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };
}
