package com.dx.ss.leetcode.searchinsertposition;

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] >= target) return i;
        }
        return len;
    }
}

