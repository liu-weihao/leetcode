package com.dx.ss.leetcode.plusone;

import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int tail = digits[digits.length - 1];
        if (tail < 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        int index = digits.length - 1;
        while (index >= 0 && digits[index] >= 9) {
            digits[index] = 0;
            index--;
        }
        if (index < 0) {
            int[] result = Arrays.copyOf(digits, digits.length + 1);
            result[0] = 1;
            return result;
        }
        digits[index] = digits[index] + 1;
        return digits;
    }
}
