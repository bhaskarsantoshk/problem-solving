package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P589NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(Node root, List<Integer> result) {
        if(root == null ) return;
        result.add(root.val);
        List<Node> list = root.children;
        if(!list.isEmpty()){
            for(int i=0;i<list.size(); i++){
                preorder(list.get(i), result);
            }
        }
    }

    private void preorderRec(Node root, List<Integer> result) {
        if(root == null ){
            return;
        }
        result.add(root.val);
        for (Node node: root.children){
            preorder(node, result);
        }
    }

    private List<Integer>  preorderIterative( Node root){
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(root == null ) return result;
        stack.push(root);
        while( !stack.isEmpty() ){
            root = stack.pop();
            result.add(root.val);
            for(int i=root.children.size()-1; i>=0; i--){
                stack.push(root.children.get(i));
            }
        }
        return result;
    }


}
