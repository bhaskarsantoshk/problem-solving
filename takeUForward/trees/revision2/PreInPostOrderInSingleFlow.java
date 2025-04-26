package takeUForward.trees.revision2;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreInPostOrderInSingleFlow {
    List<List<Integer>> treeTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if ( root == null) return res;

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));

        while (!stack.isEmpty()){
            Pair pair = stack.pop();
            if ( pair.num == 1){
                preOrder.add(pair.node.val);
                pair.num++;
                stack.push(pair);
                if( pair.node.left != null ){
                    stack.push(new Pair(pair.node.left, 1));
                }
            } else if(pair.num == 2){
                inOrder.add(pair.node.val);
                pair.num++;
                stack.push(pair);
                if( pair.node.right != null ){
                    stack.push(new Pair(pair.node.right, 1));
                }
            } else {
                postOrder.add(pair.node.val);
            }
        }
        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);
        return res;
    }

    class Pair{
        TreeNode node;
        int num;
        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }
}
