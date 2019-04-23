package com.dx.ss.leetcode.mergesortedarray;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) nums1[i] = nums2[i];
            return;
        }
        if (n == 0) return;
        int index = nums1.length - 1;
        while (n > 0 && m > 0) {
            if (nums2[n - 1] >= nums1[m - 1]) {
                nums1[index] = nums2[n - 1];
                n--;
            } else {
                nums1[index] = nums1[m - 1];
                m--;
            }
            index--;
        }
        while (n > 0) {
            nums1[index--] = nums2[--n];
        }
        System.out.println(Arrays.toString(nums1));
    }
}
