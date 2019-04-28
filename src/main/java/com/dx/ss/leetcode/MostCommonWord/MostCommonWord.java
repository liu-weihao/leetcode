package com.dx.ss.leetcode.MostCommonWord;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> stopWords = Arrays.asList(banned);
        String[] array = paragraph.split("[!?',;. ]+");
        Map<String, Integer> counter = new HashMap<>();
        for (String s : array) {
            String word = s.trim().toLowerCase();
            if (stopWords.contains(word)) continue;
            if (counter.containsKey(word)) {
                counter.put(word, counter.get(word) + 1);
            } else {
                counter.put(word, 1);
            }
        }
        int count = 0;
        String result = "";
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > count) {
                count = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MostCommonWord mostCommonWord = new MostCommonWord();
        String s = mostCommonWord.mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"});
        System.out.println(s);
    }
}
