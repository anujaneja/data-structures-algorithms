package com.anujaneja.algorithm.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * Hard: https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
    public int[] calculateLeftLimits(int[] histogram) {
        int[] left = new int[histogram.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<histogram.length;i++) {
            if(stack.isEmpty()) {
                left[i]=0;
                stack.push(0);
            } else {
                while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[i]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    left[i]=0;
                    stack.push(i);
                } else if(histogram[stack.peek()]<histogram[i]) {
                    left[i]=stack.peek()+1; // found a smaller left just left to it...Lets just put +1 to the right is the limit.
                    stack.push(i);
                }
            }
        }

        return left;
    }

    public int[] calculateRightLimits(int[] histogram) {
        int[] right = new int[histogram.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=histogram.length-1;i>=0;i--) {
                if(stack.isEmpty()) {
                    right[i]=histogram.length-1;
                    stack.push(i);
                } else {
                    while(!stack.isEmpty() && histogram[stack.peek()]>=histogram[i]) {
                        stack.pop();
                    }

                    if(stack.isEmpty()) {
                        right[i]=histogram.length-1;
                        stack.push(i);
                    } else if(histogram[stack.peek()]<histogram[i]) {
                        right[i] = stack.peek()-1;
                        stack.push(i);

                    }
                }
        }

        return right;
    }

    public int largestRectangleArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int[] leftLimits = calculateLeftLimits(heights);
        int[] rightLimits = calculateRightLimits(heights);

        for(int i=0;i<heights.length;i++) {
            int currIndexArea = (rightLimits[i]-leftLimits[i]+1)*heights[i];
            System.out.println("currIndexArea="+currIndexArea);
            maxArea = Math.max(currIndexArea,maxArea);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] histogram = new int[] {2,1,5,6,2,3};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        int[] left = largestRectangleInHistogram.calculateLeftLimits(histogram);

        System.out.println(Arrays.toString(left));

        int[] right = largestRectangleInHistogram.calculateRightLimits(histogram);

        System.out.println(Arrays.toString(right));

        System.out.println("Max Area is: "+largestRectangleInHistogram.largestRectangleArea(histogram));
    }

}
