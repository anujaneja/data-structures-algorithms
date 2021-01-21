package com.anujaneja.algorithm.educative.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Medium - https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //System.out.println(Arrays.toString(intervals));
        int i = 0;
        int start = intervals[i][0];
        int end = intervals[i][1];
        int j = i + 1;
        ArrayList<Integer[]> arr = new ArrayList<>();

        while (j < intervals.length) {
            int[] interval = intervals[j];
            boolean isMergeRequired = isMergeRequired(new int[] { start, end }, interval);
            //System.out.println("["+start+" : "+end+"]"+ ","+"["+interval[0]+" : "+interval[1]+"]"+" isOverlap:"+isOverlap);
            if (isMergeRequired) {
                start = start;
                end = Math.max(end, interval[1]);
            } else {

                arr.add(new Integer[] { start, end });
                start = interval[0];
                end = interval[1];

            }
            j++;
        }

        //add last one...
        arr.add(new Integer[] { start, end });

        int[][] result = new int[arr.size()][2];
        int index = 0;
        for (Integer[] e : arr) {
            result[index++] = new int[] { e[0], e[1] };
        }

        return result;
    }

    public static boolean isMergeRequired(int[] intervals1, int[] intervals2) {
        if (intervals1[0] <= intervals2[0] && intervals2[0] <= intervals1[1]) {
            return true;
        }
        return false;
    }

    public static int[][] mergeRecursiveDriver(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        //System.out.println(Arrays.toString(intervals));
        int i = 0;
        int start = intervals[i][0];
        int end = intervals[i][1];
        int currentIndex = i + 1;
        ArrayList<Integer[]> arr = new ArrayList<>();

        mergeRecursive(intervals, currentIndex, start, end, arr);


        int[][] result = new int[arr.size()][2];
        int index = 0;
        for (Integer[] e : arr) {
            result[index++] = new int[] { e[0], e[1] };
        }

        return result;
    }

    private static void mergeRecursive(int[][] intervals, int currentIndex, int start, int end, ArrayList<Integer[]> arr) {
        if (currentIndex == intervals.length) {
            arr.add(new Integer[]{start,end});
            return;
        }


        int[] interval = intervals[currentIndex];
        boolean isMergeRequired = isMergeRequired(new int[] { start, end }, interval);

        if (isMergeRequired) {
            //Overlapping...intervals...update end...
            end = Math.max(end, interval[1]);
        } else {
            arr.add(new Integer[]{start,end});
            start = interval[0];
            end = interval[1];

        }

        mergeRecursive(intervals, ++currentIndex, start, end, arr);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 1, 3 }, { 4, 6 } };
        int[][] mergedIntervals = mergeRecursiveDriver(intervals);
        System.out.println(Arrays.stream(mergedIntervals).map(ints -> Arrays.toString(ints)).collect(Collectors.toList()));
    }
}
