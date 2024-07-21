package company.google;

import company.TreeNode;

public class P296StepByStepDirectionsFromABinaryTreeNodeToAnother {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lca(root, startValue, destValue);
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(lca, startValue, pathToStart);
        findPath(lca, destValue, pathToDest);

        StringBuilder directions = new StringBuilder();
        directions.append("U".repeat(pathToStart.length()));
        directions.append(pathToDest);
        return directions.toString();
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        if ( node == null) return false;
        if ( node.val == target) return true;

        path.append("L");
        if ( findPath(node.left, target, path)) return true;
        path.setLength(path.length()-1);

        path.append("R");
        if ( findPath(node.right, target, path)) return true;
        path.setLength(path.length()-1);
        return false;
    }

    private TreeNode lca (TreeNode root, int p, int q){
        if ( root == null || root.val == p || root.val == q ) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca( root.right, p, q);
        if ( left == null ) return right;
        if ( right == null ) return left;
        return root;
    }
}
