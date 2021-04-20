package com.anujaneja.algorithm.educative.top_elements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 */

class Element {
    int number;
    int frequency;
    int sequenceNumber;

    public Element(int number, int frequency, int sequenceNumber) {
        this.number = number;
        this.frequency = frequency;
        this.sequenceNumber = sequenceNumber;
    }
}

class ElementComparator implements Comparator<Element> {

    @Override public int compare(Element o1, Element o2) {
        if (o1.frequency != o2.frequency) {
            return o2.frequency - o1.frequency;
        }

        return o2.sequenceNumber - o1.sequenceNumber;
    }
}

class FrequencyStack {

    PriorityQueue<Element> maxHeap        = new PriorityQueue<Element>(new ElementComparator());
    Map<Integer, Integer>  frequencyMap   = new HashMap<>();
    int                    sequenceNumber = 0;

    public static void main(String[] args) {
        FrequencyStack frequencyStack = new FrequencyStack();
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(3);
        frequencyStack.push(2);
        frequencyStack.push(1);
        frequencyStack.push(2);
        frequencyStack.push(5);
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
        System.out.println(frequencyStack.pop());
    }

    public void push(int num) {
        frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        maxHeap.offer(new Element(num, frequencyMap.get(num), sequenceNumber++));
    }

    public int pop() {
        int num = maxHeap.poll().number;

        if (frequencyMap.get(num) > 1) {
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        } else {
            frequencyMap.remove(num);
        }
        return num;
    }
}
