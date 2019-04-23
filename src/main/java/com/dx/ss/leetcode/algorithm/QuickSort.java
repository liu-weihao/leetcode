package com.dx.ss.leetcode.algorithm;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] array, int low, int high) {
        if (low > high) return;
        int pos = partition(array, low, high);
        sort(array, low, pos - 1);
        sort(array, pos + 1, high);
    }

    private int partition(int[] array, int low, int high) {
        int p = array[low];
        int tmp;
        int i = low, j = high;
        while (i < j) {
            while (i < j && array[j] >= p) {
                j--;
            }
            while (i < j && array[i] <= p) {
                i++;
            }
            if (i < j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        tmp = array[j];
        array[j] = p;
        array[low] = tmp;
        return j;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {7, 10, 5, 4, 8, 5};
        quickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
