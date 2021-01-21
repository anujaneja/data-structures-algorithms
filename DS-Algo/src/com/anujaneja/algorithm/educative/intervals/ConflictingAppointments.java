package com.anujaneja.algorithm.educative.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals) {
        boolean canAttendAllAPP = true;
        //check for invalid input or base case...
        //sort it on the basis of start...
        if(intervals==null || intervals.length<2) {
            return canAttendAllAPP;
        }

        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        int i = 0;
        int start = intervals[i].start;
        int end = intervals[i].end;
        int j=i+1;
        ArrayList<Interval> arrayList = new ArrayList<>();

        while (j < intervals.length) {
            Interval interval1 = new Interval(start,end);
            Interval interval2 = intervals[j];
            boolean isOverlappingInterval = Interval.isOverlap(interval1,interval2);

            if(isOverlappingInterval) {
                canAttendAllAPP = false;
                arrayList.add(interval1);
                arrayList.add(interval2);
            }

            j++;
        }

        System.out.println("Conflicting appointments..."+arrayList);

        return canAttendAllAPP;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
