package com.dx.ss.leetcode.CousinsNodes;

import java.util.ArrayDeque;
import java.util.Queue;

public class CousinsNodes {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        int level = 0, xLevel = 0, yLevel = 0;
        int xParent = -1, yParent = -1;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.add(node.left);
                    if (x == node.left.val) {
                        xParent = node.val;
                        xLevel = level;
                        if (level <= 1) return false;
                    }
                    if (y == node.left.val) {
                        yParent = node.val;
                        yLevel = level;
                        if (level <= 1) return false;
                    }
                }
                if (node.right != null) {
                    q.add(node.right);
                    if (x == node.right.val) {
                        xParent = node.val;
                        xLevel = level;
                        if (level <= 1) return false;
                    }
                    if (y == node.right.val) {
                        yParent = node.val;
                        yLevel = level;
                        if (level <= 1) return false;
                    }
                }
                n--;
            }
            level++;
        }
        return xParent != -1 && yParent != -1 && xParent != yParent && xLevel == yLevel;

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
