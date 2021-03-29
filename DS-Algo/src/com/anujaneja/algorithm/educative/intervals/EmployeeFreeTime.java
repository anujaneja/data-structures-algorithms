package com.anujaneja.algorithm.educative.intervals;

/**
 * Hard - https://medium.com/algorithm-and-datastructure/employee-free-time-795c7682c973
 * Hard - https://www.codertrain.co/employee-free-time
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class EmployeeInterval {
    Interval interval; // interval representing employee's working hours
    int      employeeIndex; // index of the list containing working hours of this employee
    int      intervalIndex; // index of the interval in the employee list

    public EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex) {
        this.interval = interval;
        this.employeeIndex = employeeIndex;
        this.intervalIndex = intervalIndex;
    }

    @Override public String toString() {
        return "EmployeeInterval{" +
                "interval=" + interval +
                ", employeeIndex=" + employeeIndex +
                ", intervalIndex=" + intervalIndex +
                '}';
    }
};

class EmployeeFreeTime {

    public static List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> minHeap = new PriorityQueue<>(Comparator.comparingInt(value -> value.interval.start));

        for (int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval previousInterval = minHeap.peek().interval;

        while (!minHeap.isEmpty()) {
            EmployeeInterval queueTop = minHeap.poll();
            //Non-overlapping...
            if(previousInterval.end<queueTop.interval.start) {
                result.add(new Interval(previousInterval.end,queueTop.interval.start));
                previousInterval=queueTop.interval;
            } else {
                //Overlapping interval... ; Update with new previous if current interval end is greater than previous interval only....
                if(previousInterval.end<queueTop.interval.end) {
                    previousInterval=queueTop.interval;
                }
            }

            //Add more interval for same employee in each iteration if available...
            List<Interval> empSchedule = schedule.get(queueTop.employeeIndex);

            if(empSchedule.size()>queueTop.intervalIndex+1){
                int nextIndex= queueTop.intervalIndex+1;
                minHeap.offer(new EmployeeInterval(empSchedule.get(nextIndex),queueTop.employeeIndex,nextIndex));
            }

        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Interval>> input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(5, 6))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 3), new Interval(6, 8))));
        List<Interval> result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3), new Interval(9, 12))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(6, 8))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(1, 3))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(2, 4))));
        input.add(new ArrayList<Interval>(Arrays.asList(new Interval(3, 5), new Interval(7, 9))));
        result = EmployeeFreeTime.findEmployeeFreeTime(input);
        System.out.print("Free intervals: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + ", " + interval.end + "] ");
    }
}
