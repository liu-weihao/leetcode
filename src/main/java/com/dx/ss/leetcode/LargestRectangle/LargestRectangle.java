package com.dx.ss.leetcode.LargestRectangle;

public class LargestRectangle {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int area = 0, h, t;
        for (int i=0; i<heights.length - 1; i++) {
            h = heights[i];
            t = heights[i + 1];
            if (area < Math.min(h, t)) {
                area = Math.min(h, t);
            }
        }
        return area;
    }
    public static void main(String[] args){
        LargestRectangle solution = new LargestRectangle();
        int area = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(area);
    }
}
