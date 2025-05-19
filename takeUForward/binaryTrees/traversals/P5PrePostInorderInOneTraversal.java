package takeUForward.binaryTrees.traversals;

import takeUForward.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P5PrePostInorderInOneTraversal {
    class Pair{
        TreeNode node;
        int num;

        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }
    }

    List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        TreeNode node = root;
        if ( root == null) return res;
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(node, 1));

        while ( !stack.isEmpty()){
            Pair pair = stack.pop();
            if ( pair.num == 1){
                pair.num++;
                preOrder.add(pair.node.val);
                stack.push(pair);
                if ( pair.node.left != null){
                    stack.push(new Pair(node.left, 1));
                }
            } else if ( pair.num == 2){
                pair.num++;
                inOrder.add(pair.node.val);
                stack.push(pair);
                if ( pair.node.right != null) stack.push( new Pair(node.right, 1));
            } else {
                postOrder.add(pair.node.val);
            }
        }
        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);
        return res;
    }
}
