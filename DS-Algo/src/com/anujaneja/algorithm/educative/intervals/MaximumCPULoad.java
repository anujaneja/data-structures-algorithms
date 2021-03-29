package com.anujaneja.algorithm.educative.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }

    public int getStart() {
        return start;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs==null || jobs.isEmpty()) {
            return 0;
        }

        if(jobs.size()<2) {
            return jobs.get(0).cpuLoad;
        }

        int maxCPULoad = Integer.MIN_VALUE;
        int currentCPULoad = 0;
//        jobs.sort((o1, o2) -> Integer.compare(o1.start,o2.start));
        jobs.sort(Comparator.comparingInt(Job::getStart));
        PriorityQueue<Job> queue = new PriorityQueue<>(jobs.size(),Comparator.comparingInt(value -> value.end));

        for (Job job : jobs) {
            while(!queue.isEmpty() && job.start>queue.peek().end) {
                currentCPULoad  = currentCPULoad-queue.poll().cpuLoad;
            }
            //offer and add are same...
            queue.offer(job);
            currentCPULoad= currentCPULoad+job.cpuLoad;
            maxCPULoad = Math.max(maxCPULoad,currentCPULoad);

        }

        return maxCPULoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        //Data range edge case...
        input = new ArrayList<Job>();
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        ////Data range edge case...
        input = null;
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
