package com.dx.ss.leetcode.ThreeSumClosest;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int cz = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==target){
                    return sum;
                }
                int c = sum - target;
                if(Math.abs(c)<cz){
                    result = sum;
                    cz = Math.abs(c);
                }
                if(c>0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
