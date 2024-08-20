package company.google;
import java.util.*;

import company.TreeNode;

public class P863AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParents(parentMap, root);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int level = 0;
        while ( !q.isEmpty()){
            int size = q.size();
            if ( level == k) break;;
            level++;
            for ( int i=0; i<size; i++){
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if ( parentMap.get(node) != null && !visited.contains(parentMap.get(node)) ){
                    q.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while ( !q.isEmpty()){
            res.add(q.poll().val);
        }
        return res;
    }

    private void markParents(Map<TreeNode, TreeNode> parentMap, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if ( node.left != null){
                parentMap.put(node.left, node);
                q.offer(node.left);
            }
            if ( node.right != null ){
                parentMap.put(node.right, node);
                q.offer(node.right);
            }
        }
    }
}
