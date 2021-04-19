package com.anujaneja.algorithm.educative.top_elements;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class TaskScheduler {

    public static int scheduleTasks(char[] tasks, int k) {
        int totalIntervalCount = 0;
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char task : tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        maxHeap.addAll(freqMap.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();

        while (!maxHeap.isEmpty()) {
            int n = k + 1;

            while (n > 0) {
                Map.Entry<Character, Integer> currEntry = maxHeap.poll();
                if (currEntry != null) {
                    currEntry.setValue(currEntry.getValue() - 1);
                    totalIntervalCount++;
                    queue.add(currEntry);
                    n--;
                } else {
                    break;
                }
            }

            while (!queue.isEmpty()) {
                Map.Entry<Character, Integer> entry = queue.poll();

                if (entry.getValue() > 0) {
                    maxHeap.offer(entry);
                }
            }

            if (!maxHeap.isEmpty()) {
                totalIntervalCount += n; // we'll be having 'n' idle intervals for the next iteration
            }

        }

        return totalIntervalCount;
    }

    public static void main(String[] args) {
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
    }
}
