package com.dx.ss.leetcode.SingleNumber;

import java.util.Arrays;

public class SingleNumber {

    public int singleNumber(int[] nums) {

        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public int[] singleNumbers(int[] nums) {

        int[] result = new int[2];
        int xor = 0;
        for(int var : nums) {
            xor ^= var;
        }
        int mark = xor & -xor;
        for(int var : nums) {
            if((mark & var) == 0) {
                result[0] ^= var;
            }else if((mark & var) == mark) {
                result[1] ^= var;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber insertionSort = new SingleNumber();
//        int i = insertionSort.singleNumber(new int[]{1, 2, 3, 1, 2});
//        System.out.println(i);
//        int[] nums = insertionSort.singleNumbers(new int[]{1, 2, 3, 5, 1, 2});
//        System.out.println(Arrays.toString(nums));
    }
}
