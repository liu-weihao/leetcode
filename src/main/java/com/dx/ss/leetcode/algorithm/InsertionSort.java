package com.dx.ss.leetcode.algorithm;

import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        int tmp;
        //假定第一个元素被放到了正确的位置上
        //这样，仅需遍历1 ~ n-1
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];
            int j = i;
            while (j > 0 && tmp < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(new int[]{89, 45, 68, 90, 29, 34, 17});
    }
}
