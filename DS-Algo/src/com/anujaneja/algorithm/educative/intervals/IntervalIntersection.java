package com.anujaneja.algorithm.educative.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 1.  firstList = [[0,2],[5,10],[13,23],[24,25]]
 secondList = [[1,5],[8,12],[15,24],[25,26]]
 Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]


 ------------>>>>------------------------>>>>------------------------>>>>------------------------>>>>------------------------>>>>------------


 start

 i=0 -> (0,2)    => (1,2)
 j=0 -> (1,5)



 i=1   -> (5,10)  => (5,5)
 j=0   -> (1,5)


 i=1 -> (5,10)   => (8,10)
 j=1  -> (8,12)


 i=2 -> (13,23)   => (No overlap...)
 j=1  -> (8,12)


 i=2 -> (13,23)   => (15,23)
 j=2  -> (15,24)


 i=3 ->  (24,25)  => (24,24)
 j=2  -> (15,24)

 i=3 ->  (24,25)  => (25,25)
 j=3  -> (25,26)


 end


 */
public class IntervalIntersection {

    public static int[][] intervalIntersection(int[][] firstList,int[][] secondList) {
        if((firstList==null || secondList==null)  || (firstList.length==0 || secondList.length==0)) {
            return new int[][] {};
        }
        int i=0;
        int j=0;
        ArrayList<Integer[]> arrayList = new ArrayList<>();

        while(i<firstList.length && j<secondList.length) {
            int[] interval1= firstList[i];
            int[] interval2= secondList[j];


            System.out.println("isOverlap(interval1,interval2) : "+isMergeRequired(interval1,interval2)+" - " +Arrays.toString(interval1)+" "+Arrays.toString(interval2));

            if(isMergeRequired(interval1,interval2)) {

                arrayList.add(new Integer[] {Math.max(interval1[0],interval2[0]),Math.min(interval1[1],interval2[1])});
            }

            if(interval1[1]<=interval2[1]) {
                i++;
            }

            if(interval1[1]>=interval2[1]) {
                j++;
            }
        }

        int[][] result = new int[arrayList.size()][2];
        int index = 0;
        for (Integer[] e : arrayList) {
            result[index++] = new int[] { e[0], e[1] };
        }

        return result;
    }

    public static boolean isMergeRequired(int[] intervals1, int[] intervals2) {
        if(intervals1[0]<=intervals2[0]) {
            if ((intervals1[0] <= intervals2[0] && intervals2[0] <= intervals1[1])) {
                return true;
            }
        } else{
            return isMergeRequired(intervals2,intervals1);
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] intervals1 = new int[][] { {0,2},{5,10},{13,23},{24,25} };
        int[][] intervals2 = new int[][] { {1,5},{8,12},{15,24},{25,26} };

        int[][] intervalsIntersectionArr = intervalIntersection(intervals1,intervals2);

        System.out.println(Arrays.stream(intervalsIntersectionArr).map(ints -> Arrays.toString(ints)).collect(Collectors.toList()));
    }
}
