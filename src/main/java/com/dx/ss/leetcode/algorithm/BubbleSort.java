package com.dx.ss.leetcode.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序：
 * 相邻的两个元素依次作比较，如果前者比后者大，就交换之。
 */
public class BubbleSort {

    public void sort(int[] array) {
        if (array == null || array.length <= 1) return;
        int tmp;//用于交换元素
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        b.sort(new int[]{89, 45, 68, 90, 29, 34, 17});
    }
}
