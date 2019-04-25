package com.dx.ss.leetcode.LevelOrderTraversal;

import java.util.*;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelDataList = new ArrayList<>(2);
            int n = queue.size();
            while (n > 0) {
                TreeNode node = queue.poll();
                if (node == null) continue;
                levelDataList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                n--;
            }
            if (!levelDataList.isEmpty()) {
                stack.push(levelDataList);
            }
        }
        while (!stack.empty()) {
            resultList.add(stack.pop());
        }
        return resultList;
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
