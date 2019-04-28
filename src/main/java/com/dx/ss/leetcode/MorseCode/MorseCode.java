package com.dx.ss.leetcode.MorseCode;

import java.util.HashSet;
import java.util.Set;

public class MorseCode {

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;
        if (words.length == 1) return 1;
        String[] dic = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> codeSet = new HashSet<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder builder = new StringBuilder(chars.length);
            for (char c : chars) {
                builder.append(dic[97 - c]);
            }
            codeSet.add(builder.toString());
        }
        return codeSet.size();
    }
    public static void main(String[] args){
        String[] words = new String[]{"gin", "zen", "gig", "msg"};
        MorseCode morseCode = new MorseCode();
        int i = morseCode.uniqueMorseRepresentations(words);
        System.out.println(i);
    }
}
