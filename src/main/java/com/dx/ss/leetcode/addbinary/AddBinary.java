package com.dx.ss.leetcode.addbinary;

public class AddBinary {

    public String addBinary(String a, String b) {

        String result = "";
        int diff = a.length() - b.length();
        if (diff > 0) {
            while (diff > 0) {
                b = "0" + b;
                diff--;
            }
        } else {
            while (diff < 0) {
                a = "0" + a;
                diff++;
            }
        }
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        int plus = 0; //进位
        int index = a.length();
        while (index > 0) {
            index--;
            if (as[index] != bs[index]) {
                if (plus > 0) {
                    result = "0" + result;
                } else {
                    result = "1" + result;
                }
            } else {
                if (plus > 0) {
                    plus--;
                    result = "1" + result;
                } else {
                    result = "0" + result;
                }
                if (as[index] == '1') {
                    plus++;
                }
            }
        }
        while (plus > 0) {
            result = "1" + result;
            plus--;
        }
        return result;
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String result = addBinary.addBinary("10111", "101");
        System.out.println(result);
    }
}
