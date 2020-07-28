import java.io.*;
import java.util.*;

public class IsBST {

    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
        int t= in.nextInt();
        while (t!=0){
            int n = in.nextInt();
            TreeNode root = null;
            int arr[]= new int[n];
            for ( int i=0; i<n;i++){
                arr[i]=in.nextInt(); 
            }
            root =insertLevelOrder(arr, root, 0 );
            boolean res = isBST(root);
            String result = (res == true) ? "True":"False";
            System.out.println(result);
            t--;
        }
    }
    
    private static boolean isBST(TreeNode root){
       return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static boolean isBST(TreeNode root, int min, int max){
        if ( root == null ) return true;
        if ( root.val <= min || root.val >= max){
            return false;
        }
        return isBST(root.left,min, root.val ) && isBST(root.right, root.val, max);
    }
    
    public static TreeNode insertLevelOrder(int[] arr, TreeNode root, 
                                                int i) 
    { 
        // Base case for recursion 
        if (i < arr.length) { 
            TreeNode temp = new TreeNode(arr[i]); 
            root = temp; 
  
            // insert left child 
            root.left = insertLevelOrder(arr, root.left, 
                                             2 * i + 1); 
  
            // insert right child 
            root.right = insertLevelOrder(arr, root.right, 
                                               2 * i + 2); 
        } 
        return root; 
    } 
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val){
            this.val =val;
            this.left = null;
            this.right = null;
        }
    }
}
