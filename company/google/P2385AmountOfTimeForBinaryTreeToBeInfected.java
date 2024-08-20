package company.google;

import company.TreeNode;

import java.util.*;

public class P2385AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents( parentMap, root);
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode currentNode = serach(root, start);
        Set<TreeNode> visited = new HashSet<>();
        q.offer(currentNode);
        visited.add(currentNode);
        int level = 0;
        while ( !q.isEmpty()) {
            int size = q.size();
            level++;
            for ( int i=0; i<size; i++){
                currentNode = q.poll();
                if ( currentNode.left != null && !visited.contains(currentNode.left)){
                    q.offer(currentNode.left);
                    visited.add(currentNode.left);
                }
                if ( currentNode.right != null && !visited.contains(currentNode.right)){
                    q.offer(currentNode.right);
                    visited.add(currentNode.right);
                }
                TreeNode parent = parentMap.get(currentNode);
                if ( parent != null && !visited.contains(parent)){
                    q.offer(parent);
                    visited.add(parent);
                }
            }
        }
        return level-1;
    }

    private TreeNode serach(TreeNode root, int start) {
        if ( root == null) return null;
        if ( root.val == start) return root;
        TreeNode left = serach(root.left, start);
        if ( left != null ) return left;
        TreeNode right = serach(root.right, start);
        if ( right != null ) return right;
        return null;
    }

    private void markParents(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if ( node.left != null ) {
                parentMap.put(node.left, node);
                q.offer(node.left);
            }

            if ( node.right != null){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
}
