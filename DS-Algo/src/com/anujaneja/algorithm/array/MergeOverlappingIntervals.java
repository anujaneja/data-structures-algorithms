package com.anujaneja.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Merge Overlapping Intervals
 Given a set of time intervals in any order, merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals. Let the intervals be represented as pairs of integers for simplicity.
 For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become {5, 8}


 * https://stackoverflow.com/questions/31670849/merge-overlapping-intervals
 */
class Interval {
    int low;
    int high;

    public Interval(int low,int high) {
        this.low = low;
        this.high = high;
    }

    public String toString() {
        return "( "+low+" , "+high+" )";
    }
}

public class MergeOverlappingIntervals {

    static ArrayList<Interval> mergeOverlappingIntervals(ArrayList<Interval> intervalList) {
        ArrayList<Interval> result = new ArrayList<>();

        for(int i=0;i<intervalList.size();i++) {
            Interval current = intervalList.get(i);
            int low=current.low;
            int high = current.high;

            for(i=i+1;i<intervalList.size();i++) {
                if(high>intervalList.get(i).low) {
                    high=intervalList.get(i).high;
                    continue;
                } else {
                    break;
                }
            }

            result.add(new Interval(low,high));

            if(i<intervalList.size() && intervalList.get(i).low>low) {
                result.add(new Interval(intervalList.get(i).low,intervalList.get(i).high));
            }


        }

        return result;

    }

    public static void main(String[] s) {
        ArrayList<Interval> intervalList = new ArrayList<Interval>();
        intervalList.add(new Interval(1,3));
        intervalList.add(new Interval(11,12));
        intervalList.add(new Interval(3,6));
        intervalList.add(new Interval(7,10));
        intervalList.add(new Interval(13,14));

        Comparator<Interval> intervalComparator =  new Comparator<Interval>(){

            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.low-o2.low;
            }
        };

        Collections.sort(intervalList,intervalComparator);

        ArrayList<Interval> result = mergeOverlappingIntervals(intervalList);

        System.out.println("Output: "+result);
    }
}
