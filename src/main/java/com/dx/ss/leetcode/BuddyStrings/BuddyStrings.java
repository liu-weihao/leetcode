package com.dx.ss.leetcode.BuddyStrings;

public class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        int lenA = A.length(), lenB = B.length();
        if(lenA != lenB || lenA == 0 || lenB == 0) return false;
        int[] index = new int[26];
        boolean flag = false;
        int cnt = 0;
        char chA = 0, chB = 0;
        for(int i = 0; i < lenA; i++){
            if(A.charAt(i) != B.charAt(i)){
                cnt++;
                if(cnt == 1){
                    chA = A.charAt(i);
                    chB = B.charAt(i);
                }else if(cnt == 2){
                    if(chA != B.charAt(i) || chB != A.charAt(i))
                        return false;
                }else return false;
            }

            if(!flag){
                flag = ++index[A.charAt(i)-'a'] >= 2;
            }
        }
        return cnt != 0 || flag;
    }
}
