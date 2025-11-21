package takeUForward.QR;

import java.util.*;

public class P39MinimumTimeTakenToBurn {
    public int timeToBurnTree(TreeNode root, int start) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode target = bfsToParents(root, start, map);
        return getMaxDistance(map, target);
    }

    private int getMaxDistance(Map<TreeNode, TreeNode> map, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> vis = new HashSet<>();
        int max  = 0;
        vis.add(target);
        while ( !q.isEmpty()){
            int size = q.size();
            boolean burnt = false;

            for ( int i=0; i<size; i++){
                TreeNode node = q.poll();
                if ( node.left != null && !vis.contains(node.left)){
                    q.offer(node.left);
                    vis.add(node.left);
                    burnt = true;
                }
                if ( node.right != null && !vis.contains(node.right)){
                    q.offer(node.right);
                    vis.add(node.right);
                    burnt = true;
                }
                if ( map.containsKey(node) && !vis.contains(map.get(node))){
                    q.offer(map.get(node));
                    burnt = true;
                    vis.add(map.get(node));
                }
            }
            if ( burnt ) max++;

        }
        return max;
    }

    private TreeNode bfsToParents(TreeNode root, int start, Map<TreeNode, TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode res = new TreeNode(-1);
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if ( node.data == start) res = node;
            if ( node.left != null){
                map.put(node.left, node);
                q.offer(node.left);
            }
            if ( node.right != null){
                map.put(node.right, node);
                q.offer(node.right);
            }
        }
        return res;
    }
}
