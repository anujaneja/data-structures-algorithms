package com.anujaneja.algorithm;

/**
 * linkedin-interview-questions
 Given a sorted array with duplicates and a number, find the range in the
 form of (startIndex, endIndex) of that number. For example,

 find_range({0 2 3 3 3 10 10}, 3) should return (2,4).
 find_range({0 2 3 3 3 10 10}, 6) should return (-1,-1).
 The array and the number of duplicates can be large.
 */
public class FindLowAndHighInSortedIniniteArray {

    private static int[] bound=new int[]{-1,-1};

    private static  void findLowAndHighIndexOfElement(int[] arr,int key,int start, int end) {



        if(start>end) {
            return;
        }

        int mid = (start+ end)/2;

        System.out.println("start : "+start +" end : "+end+" key="+key+" arr[mid]="+arr[mid]);

        if(arr[mid]==key) {

            if (bound[0]==-1 || bound[0]>mid){
                bound[0]=mid;
            }

            if(bound[1]<mid || bound[1]==-1){
                bound[1]=mid;
            }

            if(mid==start || (key>=arr[mid+1])) {
                //can be in right half as well.
                findLowAndHighIndexOfElement(arr,key,mid+1,end*2);
                return;
            }

            if(key<=arr[mid+1]) {
                findLowAndHighIndexOfElement(arr,key,start,mid-1);
                return;
            }
        }

        if(key<=arr[mid] && key>=arr[start]) {
            findLowAndHighIndexOfElement(arr,key,start,mid-1);

        }

        if(key>=arr[mid+1]) {
            findLowAndHighIndexOfElement(arr,key,mid+1,end*2);

        }


    }

    public static void main(String[] s) {
        int[] arr = new int[]{1,1,2,2,3,4,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,7,7,7,8,9,10,11,12,12,13,14,15,16,17,18,19,20,21,22,23,24,25
        ,26,27,27,28,29,30,31,32,33,34,35};
        int key=1;
        System.out.println("Searching for "+key);
        findLowAndHighIndexOfElement(arr,key,0,2);
        System.out.println("start index: "+bound[0] +" end index: "+bound[1]);

        key=2;
        bound=new int[]{-1,-1};
        System.out.println("Searching for "+key);
        findLowAndHighIndexOfElement(arr,key,0,2);
        System.out.println("start index: "+bound[0] +" end index: "+bound[1]);

        key=3;
        bound=new int[]{-1,-1};
        System.out.println("Searching for "+key);
        findLowAndHighIndexOfElement(arr,key,0,2);
        System.out.println("start index: "+bound[0] +" end index: "+bound[1]);

        key=6;
        bound=new int[]{-1,-1};
        System.out.println("Searching for "+key);
        findLowAndHighIndexOfElement(arr,key,0,2);
        System.out.println("start index: "+bound[0] +" end index: "+bound[1]);


        key=5 ;
        bound=new int[]{-1,-1};
        System.out.println("Searching for "+key);
        findLowAndHighIndexOfElement(arr,key,0,2);
        System.out.println("start index: "+bound[0] +" end index: "+bound[1]);

    }
}
