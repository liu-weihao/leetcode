package com.dx.ss.leetcode.BalancedBinaryTree;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }
        int left = height(root.left);
        int rigth = height(root.right);

        return Math.abs(left - rigth) <= 1 && isBalanced(root.left) &&  isBalanced(root.right) ;

    }

    public int height(TreeNode root){

        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);


        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
