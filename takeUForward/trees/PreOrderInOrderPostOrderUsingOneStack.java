package takeUForward.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderInOrderPostOrderUsingOneStack {
    public void preInPostOrderTraversal(TreeNode root){
        if ( root == null ) return;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        List<Integer> inorder = new ArrayList<>();
        List<Integer> preorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        while ( !stack.isEmpty() ){
            Pair pair = stack.pop();
            if ( pair.number == 1){
                preorder.add(pair.node.val);
                pair.number++;
                stack.push(pair);

                if ( pair.node.left != null ){
                    stack.push(new Pair(pair.node.left, 1));
                }
            } else if ( pair.number == 2){
                inorder.add(pair.node.val);
                pair.number++;
                stack.push(pair);
                if ( pair.node.right != null ){
                    stack.push(new Pair(pair.node.right, 1));
                }
            } else {
                postorder.add(pair.node.val);
            }
        }
    }

    class Pair{
        TreeNode node;
        int number;

        Pair(){};
        Pair(TreeNode node , int number){
            this.node = node;
            this.number = number;
        }
    }
}
