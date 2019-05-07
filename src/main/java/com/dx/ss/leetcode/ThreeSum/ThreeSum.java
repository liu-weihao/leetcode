package com.dx.ss.leetcode.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return Collections.emptyList();
        //排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < nums.length - 2; index++) {
            int head = index + 1, tail = nums.length - 1;
            while (head < tail) {
                int sum = nums[index] + nums[head] + nums[tail];
                if (sum == 0) {
                    List<Integer> integers = Arrays.asList(nums[index], nums[head], nums[tail]);
                    if (!result.contains(integers)) result.add(integers);
                    head++;
                    tail--;
                } else if (sum > 0) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> list = threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }
}
