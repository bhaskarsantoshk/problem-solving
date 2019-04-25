package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class P590NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if( root == null ){
            return;
        }
        for(int i= 0; i<=root.children.size()-1; i++){
            postorder(root.children.get(i), result);
        }
        result.add(root.val);
    }
}
