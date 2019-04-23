package com.dx.ss.leetcode.ExcelColumnTitle;

public class ExcelColumnTitle {

    public String convertToTitle(int n) {
        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int tmp = n;
        while (tmp > 0) {
            tmp--;
            sb.append((char) (65 + (tmp % 26)));
            tmp = tmp / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ExcelColumnTitle excelColumnTitle = new ExcelColumnTitle();
        System.out.println(excelColumnTitle.convertToTitle(52));
    }
}
