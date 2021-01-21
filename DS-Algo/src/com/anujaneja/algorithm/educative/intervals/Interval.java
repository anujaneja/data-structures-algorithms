package com.anujaneja.algorithm.educative.intervals;

public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public static boolean isOverlap(Interval intervals1, Interval intervals2) {
        if(intervals1.start<=intervals2.start) {
            if ((intervals1.start <= intervals2.start && intervals2.start <= intervals1.end)) {
                return true;
            }
        } else{
            return isOverlap(intervals2,intervals1);
        }

        return false;
    }
}
