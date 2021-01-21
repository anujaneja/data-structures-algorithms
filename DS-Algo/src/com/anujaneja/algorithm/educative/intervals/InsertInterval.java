package com.anujaneja.algorithm.educative.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Medium - https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals==null || intervals.length<1) {
            return new int[][]{newInterval};
        }

        int i=0;
        ArrayList<Integer[]> resultAL = new ArrayList<>();
        int start=newInterval[0];
        int end=newInterval[1];

        while(i<intervals.length) {
            int[] interval = intervals[i];
            boolean isOverlappingIntervals =false;
            if(interval[0]>=start) {
                isOverlappingIntervals =isOverlappingIntervals(new int[]{start,end},interval);
            } else {
                isOverlappingIntervals =isOverlappingIntervals(interval,new int[]{start,end});
            }


            if(isOverlappingIntervals) {

                start=Math.min(start,interval[0]);
                end=Math.max(end,interval[1]);
                //System.out.println("Start="+start+" end="+end);
            } else if(interval[0]>start && interval[0]>end) {
                resultAL.add(new Integer[]{start,end});
                start=interval[0];
                end=interval[1];
            } else if(interval[0]<start && interval[0]<end){
                resultAL.add(new Integer[]{interval[0],interval[1]});
            }

            i++;

        }

        resultAL.add(new Integer[] { start, end });

        int[][] result = new int[resultAL.size()][2];
        int index = 0;
        for (Integer[] e : resultAL) {
            result[index++] = new int[] { e[0], e[1] };
        }

        return result;
    }

    public static boolean isOverlappingIntervals(int[] interval1,int[] interval2) {

        if(interval2[0]>=interval1[0] && interval2[0]<=interval1[1]) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        //[[3,5],[4,8],[6,7],[8,10],[12,16]]
        // [1,2]
        int[][] intervals = new int[][] {{3,5},{4,8},{6,7},{8,10},{12,16}};
        int[] newInterval = new int[] {1,2};
        int[][] result = insert(intervals,newInterval);
        System.out.println(Arrays.stream(result).map(ints -> Arrays.toString(ints)).collect(Collectors.toList()));
    }
}
