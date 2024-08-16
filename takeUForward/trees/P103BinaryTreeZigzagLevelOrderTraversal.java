package takeUForward.trees;
import java.util.*;

public class P103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ) return result;
        Stack<TreeNode> currentLevel =  new Stack<>();
        int level = 0;
        currentLevel.push(root);
        boolean leftToRight = true;
        while ( !currentLevel.isEmpty()){
            int size = currentLevel.size();
            result.add(new ArrayList<>());
            Stack<TreeNode> nextLevel = new Stack<>();
            for ( int i=0; i<size; i++){
                TreeNode node = currentLevel.pop();
                result.get(level).add(node.val);
                if ( leftToRight ){
                    if ( node.left != null ) nextLevel.push(node.left);
                    if ( node.right != null ) nextLevel.push(node.right);
                } else {
                    if ( node.right != null ) nextLevel.push(node.right);
                    if ( node.left != null ) nextLevel.push(node.left);
                }
            }
            currentLevel = nextLevel;
            level++;
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrderUsingQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if ( root == null ) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        while ( !queue.isEmpty()){
            int size = queue.size();
            Deque<Integer> list = new LinkedList<>();
            for ( int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (leftToRight){
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(new ArrayList<>(list));
            leftToRight = !leftToRight;
        }
        return result;
    }
}
