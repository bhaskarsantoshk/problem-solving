package company.amazon.leetcode;

import java.util.Stack;

public class P1628DesignAnExpressionTreeWithEvaluateFunction {

}

/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class BinaryTreeNode extends Node {
    // Constructor
    String val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(String val) {
        this.val = val;
    }

    @Override
    public int evaluate() {
        return dfs(this);
    }

    private int dfs(BinaryTreeNode root) {
        if ( root.left == null && root.right == null ){
            return Integer.valueOf(root.val);
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        String operator = root.val;
        int res = 0;
        if ( operator.equals("+")){
            res = left + right;
        }
        else if ( operator.equals("-")){
            res = left - right;
        } else if ( operator.equals("*")){
            res = left * right;
        } else {
            res = left / right;
        }
        return res;
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        String operators = "+-*/";
        Stack<BinaryTreeNode> stack = new Stack<>();
        for ( String str: postfix){
            BinaryTreeNode cur  = new BinaryTreeNode(str);
            if ( operators.contains(str)){
                cur.right = stack.pop();
                cur.left = stack.pop();
                stack.push(cur);
            } else {
                stack.push(cur);
            }
        }
        return stack.pop();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
