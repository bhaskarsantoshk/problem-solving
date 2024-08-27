package takeUForward.trees;

public class FloorFromBST {
    public static int floor(BinaryTreeNode<Integer> node, int input) {
        BinaryTreeNode<Integer> cur = node;
        int ans = -1;
        while ( cur != null){
            if ( cur.data == input) return cur.data;
            if ( cur.data < input){
                ans = cur.data;
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return ans;
    }

    class BinaryTreeNode <Integer> {
        int data;
        BinaryTreeNode left, right;
    }
}
