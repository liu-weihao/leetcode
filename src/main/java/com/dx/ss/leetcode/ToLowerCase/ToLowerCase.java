package com.dx.ss.leetcode.ToLowerCase;

public class ToLowerCase {

    public String toLowerCase(String str) {
        if (str == null || str.length() == 0) return null;
        char[] array = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char c : array) {
            if (c >= 65 && c <= 90) {
                builder.append((char) (c + 32));
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args){
        ToLowerCase toLowerCase = new ToLowerCase();
        System.out.println(toLowerCase.toLowerCase("Wx09ASDF40vw"));
    }
}
