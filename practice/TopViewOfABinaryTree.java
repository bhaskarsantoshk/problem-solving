package practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfABinaryTree {
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public void topView(TreeNode root) {
        topView(root, 0);
    }

    private void topView(TreeNode root, int level) {
        if ( root == null ){
            return;
        }

        Queue<QueuePack> queue = new LinkedList<>();
        queue.offer(new QueuePack(level, root));


        while ( !queue.isEmpty() ){

                QueuePack qp = queue.poll();

                if ( !map.containsKey(qp.tnode)){
                    System.out.println(qp.tnode.val);
                }
            }
        }

    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    class QueuePack {
        int level;
        TreeNode tnode;

        public QueuePack(int level, TreeNode tnode) {
            this.level = level;
            this.tnode = tnode;
        }
    }
}
