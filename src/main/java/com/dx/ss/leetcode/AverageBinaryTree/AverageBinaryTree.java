package com.dx.ss.leetcode.AverageBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AverageBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        queue.add(root);
        levelMap.put(root, 0);

        int curLevel = 0;
        int curLevelNumber = 0;
        double avg = 0;

        while (!queue.isEmpty()) {
            TreeNode x = queue.poll();
            int xLevel = levelMap.get(x);
            if (xLevel == curLevel) {
                curLevelNumber++;
                avg += x.val;
            } else {
                res.add(avg / curLevelNumber);
                avg = x.val;
                curLevel = xLevel;
                curLevelNumber = 1;
            }
            if (x.left != null) {
                queue.add(x.left);
                levelMap.put(x.left, curLevel + 1);
            }
            if (x.right != null) {
                queue.add(x.right);
                levelMap.put(x.right, curLevel + 1);
            }
        }
        res.add(avg / curLevelNumber);
        return res;
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
