package com.anujaneja.algorithm.array.matrix;

class SearchIn2DMatrix {
    //Looks like a binary Search...
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        
        if(target>=matrix[0][0] && target<=matrix[m-1][n-1]) {
                for(int i=0;i<m;i++) {
                    if(target<=matrix[i][n-1] && target>=matrix[i][0]) {
                        return binarySearch(matrix[i],target); 
                    } else {
                        continue;
                    }
                }    
        } else {
            return false;
        }   
        
        return false;
    }
    
    boolean binarySearch(int[] arr,int target) {
        return binarySearchRec(arr,target,0,arr.length-1)!=-1;
    }
    
    int binarySearchRec(int[] arr,int target,int low,int high) {
        if(low>high) {
            return -1;
        }
        
        int mid = (low+high)/2;
        if(arr[mid]==target) {
            return mid;
        } else if(target>arr[mid]) {
            return binarySearchRec(arr,target,mid+1,high);
        } else {
            return binarySearchRec(arr,target,low,mid-1);
        }
    }
    
}