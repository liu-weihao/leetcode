package com.dx.ss.leetcode;

import com.dx.ss.leetcode.mergesortedarray.MergeSortedArray;

public class Main {

    public static void main(String[] args) {
//        ValidParentheses vp = new ValidParentheses();
//        boolean valid = vp.isValid("[{()}]");
//        System.out.println(valid);

//        RemoveElement re = new RemoveElement();
//        int newLength = re.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
//        System.out.println(newLength);

//        RemoveDuplicates rd = new RemoveDuplicates();
//        int len = rd.removeDuplicates(new int[]{0, 1, 2, 2, 3});
//        System.out.println(len);

//        PlusOne po = new PlusOne();
//        int[] result = po.plusOne(new int[]{9, 1, 9});
//        System.out.println(Arrays.toString(result));

        MergeSortedArray msa = new MergeSortedArray();
        int[] nums1 = {2, 0};
        int[] nums2 = {1};
        msa.merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
    }
}
