package books.EPI.BinaryTrees;

public class LCAWithParentFields {

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q){
        int depth1 = getDepth(p);
        int depth2 = getDepth(q);
        if(depth1 > depth2){
           BinaryTreeNode temp = p;
           p = q;
           q = temp;
        }
        int depthDiff = Math.abs(depth1-depth2);
        while (depthDiff-- > 0){
            p = p.parent;
        }
        while (p != q){
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    private static int getDepth(BinaryTreeNode<Integer> node) {
        int depth = 0;
        while (node.parent != null ){
            depth++;
            node = node.parent;
        }
        return depth;
    }
    
    private static class BinaryTreeNode<Integer>{
        private Integer data;
        private BinaryTreeNode parent;
        private BinaryTreeNode left, right;
    }
}
