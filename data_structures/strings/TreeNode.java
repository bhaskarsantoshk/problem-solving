package data_structures.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int data;
    public String text;

    public ArrayList<TreeNode> Children = new ArrayList<TreeNode>();
    public TreeNode(int data){
        this.data = data;
    }

    public TreeNode(String text){
        this.text = text;
    }

    public void printLevelOrder(TreeNode root){
        if ( root == null ) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while ( !queue.isEmpty() ){
            int sizeOfLevel = queue.size();
            for ( int i=0; i<sizeOfLevel; i++){
                TreeNode node = queue.poll();
                for ( int j=0; j < node.Children.size(); j++){
                    queue.offer(node.Children.get(j));
                }
                System.out.print(node.text);
            }
            System.out.println();
        }
    }
}
