package bytebybyte;

public class CheckBST {

    private class Node{
        private  int value;
        private Node left;
        private Node right;
    }

    public boolean isBST(Node root){
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int minValue, int maxValue) {
        if ( root == null ) return true;
        if (root.value < minValue || root.value > maxValue){
            return false;
        }
        return isBST(root.left, minValue, root.value) && isBST(root.right , root.value+1, maxValue);
    }

}
