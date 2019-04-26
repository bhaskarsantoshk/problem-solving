package LeetCode;

public class P559MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if(root == null ){
            return 0;
        }
        int max = 0;
        for(int i=0;i<root.children.size(); i++){
            int val = maxDepth(root.children.get(i));
            if(val > max){
                max = val;
            }
        }
        return max+1;

    }
}
