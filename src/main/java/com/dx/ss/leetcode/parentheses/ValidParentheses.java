package com.dx.ss.leetcode.parentheses;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            Character pop = stack.pop();
            if ((pop == '{' && c != '}') || (pop == '(' && c != ')') || (pop == '[' && c != ']')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
