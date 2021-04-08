package com.anujaneja.algorithm.educative.binarySearch;


class ArrayReader {
    int[] arr;

    ArrayReader(int[] arr) {
        this.arr = arr;
    }

    public int get(int index) {
        if (index >= arr.length)
            return Integer.MAX_VALUE;
        return arr[index];
    }
}

/**
 * Medium - https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 *
 */
public class SearchInfiniteSortedArray {

    public static int search(ArrayReader reader, int key) {
        //Find the bound first...
        int start = 0;
        int end = 1;
        int bs = 2;

        while(key>reader.get(end)) {
            start = end+1;
            bs=bs*2;
            end= start+bs-1;
        }

        //System.out.println("start= "+start+" end="+end);
        return binarySearch(reader,key,start,end);
    }

    public static int binarySearch(ArrayReader reader,int key,int start,int end) {

        if(start>end) {
            return -1;
        }
        int mid = start+(end-start)/2;

        if(reader.get(mid)==key) {
            return mid;
        } else if(reader.get(mid)>key) {
            return binarySearch(reader,key,start,mid-1);
        }  else if(reader.get(mid)<key){
            return binarySearch(reader,key,mid+1,end);
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }
}

