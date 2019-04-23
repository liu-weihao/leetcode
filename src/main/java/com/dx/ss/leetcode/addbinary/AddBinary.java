package com.dx.ss.leetcode.addbinary;

public class AddBinary {

    public String addBinary(String a, String b) {

        String result = "";
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int plus = 0; //进位
        int i = as.length - 1, j = bs.length - 1;
        while (i > 0 && j > 0) {
            if (as[i] != bs[j]) {
                result = "1" + result;
                continue;
            }
            result = "0" + result;
            if (as[i] != 0) {
                plus = 1;
            }
        }
        return result;
    }
}
