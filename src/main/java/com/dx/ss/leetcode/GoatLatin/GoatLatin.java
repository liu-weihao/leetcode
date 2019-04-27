package com.dx.ss.leetcode.GoatLatin;

import java.util.Arrays;

public class GoatLatin {

    public String toGoatLatin(String S) {

        StringBuilder builder = new StringBuilder();
        String[] words = S.split(" ");
        int index = 1;
        for (String word : words) {
            int tmp = index;
            char[] chars = word.toCharArray();
            if (chars.length == 1) {
                builder.append(word).append("ma");
            } else {
                char first = chars[0];
                if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'
                        || first == 'A' || first == 'E' || first == 'I' || first == 'O' || first == 'U') {
                    builder.append(word).append("ma");
                } else {
                    builder.append(Arrays.copyOfRange(chars, 1, chars.length)).append(first).append("ma");
                }
            }
            while (tmp > 0) {
                builder.append("a");
                tmp--;
            }
            if (index != words.length) {
                builder.append(" ");
            }
            index++;
        }
        return builder.toString();
    }
}
