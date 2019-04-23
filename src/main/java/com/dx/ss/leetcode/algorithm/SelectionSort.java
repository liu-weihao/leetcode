package com.dx.ss.leetcode.algorithm;

import java.util.Arrays;

/**
 * 选择排序算法：
 * 每次找到最小的一个元素，与最前面最小元素后一位进行交换。
 */
public class SelectionSort {

    public void sort(int[] array) {

        if (array == null || array.length <= 1) return;
        int tmp; //用于交换元素
        int min_index; //记录当前循环中值最小的元素下标位置
        for (int i = 0; i < array.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min_index]) min_index = j;
            }
            if (min_index != i) {
                tmp = array[i];
                array[i] = array[min_index];
                array[min_index] = tmp;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(new int[]{89, 45, 68, 90, 29, 34, 17});
    }
}
