package com.dx.ss.leetcode.RobotReturnOrigin;

public class RobotReturnOrigin {

    public boolean judgeCircle(String moves) {

        int vertical = 0, horizon = 0;
        char[] chars = moves.toCharArray();
        for (char c : chars) {
            if (c == 'D') {
                vertical--;
            } else if (c == 'U') {
                vertical++;
            } else if (c == 'L') {
                horizon--;
            } else if (c == 'R') {
                horizon++;
            }
        }
        return vertical == 0 && horizon == 0;
    }


}
