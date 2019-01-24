package CrackingTheCodingInterview.TreesAndGraphs;

public class MinimalTree {
    TreeNode createMinimalBST( int[] array){
        return createMinimalBST(array, 0, array.length-1);
    }

    private TreeNode createMinimalBST(int[] array, int start, int end) {
        if(end < start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(array[mid]);
        node.left = createMinimalBST(array, start, mid-1);
        node.right = createMinimalBST(array, mid+1, end);
    }
}
