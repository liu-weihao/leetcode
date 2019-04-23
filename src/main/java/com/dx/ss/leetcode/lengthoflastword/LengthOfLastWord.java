package com.dx.ss.leetcode.lengthoflastword;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) return 0;
        String[] arrays = s.split(" ");
        return arrays[arrays.length - 1].length();
    }
}
