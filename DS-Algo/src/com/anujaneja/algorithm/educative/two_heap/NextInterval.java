package com.anujaneja.algorithm.educative.two_heap;

import com.anujaneja.algorithm.educative.intervals.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Medium - https://leetcode.com/problems/find-right-interval/
 * HashMap , BinarySearch...
 */
public class NextInterval {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[] { new Interval(2, 3), new Interval(3, 4), new Interval(5, 6) };
        int[] result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        intervals = new Interval[] { new Interval(3, 4), new Interval(1, 5), new Interval(4, 6) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
        System.out.println();

        //        [[1,12],[2,9],[3,10],[13,14],[15,16],[16,17]]

        intervals = new Interval[] {
                new Interval(1, 12), new Interval(2, 9), new Interval(3, 10), new Interval(13, 14), new Interval(15, 16),
                new Interval(16, 17) };
        result = NextInterval.findNextInterval(intervals);
        System.out.print("Next interval indices are: ");
        for (int index : result)
            System.out.print(index + " ");
    }

    private static int[] findNextInterval(Interval[] intervals) {
        if (intervals == null || intervals.length == 1) {
            return new int[] { -1 };
        }

        Map<Integer, Integer> intervalToIndex = new HashMap<>();
        int[] result = new int[intervals.length];
        ArrayList<Interval> arrayList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            intervalToIndex.put(intervals[i].start, i);
            arrayList.add(intervals[i]);
        }

        Collections.sort(arrayList, (o1, o2) -> o1.start - o2.start);

        for (int i = 0; i < intervals.length; i++) {
            Interval interval = intervals[i];
            Interval nextInterval = findNextIntervalBinary(arrayList, interval, 0, arrayList.size() - 1);
            result[i] = nextInterval != null ? intervalToIndex.get(nextInterval.start) : -1;
        }

        return result;
    }

    private static Interval findNextIntervalBinary(ArrayList<Interval> arrayList, Interval interval, int start, int end) {
        Interval result = null;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arrayList.get(mid).start >= interval.end) {
                result = arrayList.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    /**
     * LeetCode solution...
     * @param intervals
     * @param interval
     * @param start
     * @param end
     * @return
     */
    private int[] findNextIntervalBinary(ArrayList<int[]> intervals, int[] interval, int start, int end) {
        int[] result = null;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (intervals.get(mid)[0]>= interval[1]) {
                result = intervals.get(mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return result;
    }

    public int[] findRightInterval(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return new int[] { -1 };
        }

        Map<Integer, Integer> intervalToIndex = new HashMap<>();
        int[] result = new int[intervals.length];
        ArrayList<int[]> arrayList = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            //interval start -> index...
            intervalToIndex.put(intervals[i][0], i);
            arrayList.add(intervals[i]);
        }

        Collections.sort(arrayList, (o1, o2) -> (o1[0] - o2[0]));

        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] nextInterval = findNextIntervalBinary(arrayList, interval, 0, intervals.length - 1);
            result[i] = nextInterval != null ? intervalToIndex.get(nextInterval[0]) : -1;
        }

        return result;
    }
}
