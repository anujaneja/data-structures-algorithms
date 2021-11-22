package com.anujaneja.algorithm.dp.matrix;

import java.util.Arrays;

//Easy - https://leetcode.com/problems/unique-paths/

class Point {
    int x;
    int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override public String toString() {
        return "("+ x + "," + y + ")";
    }
}
public class UniquePathsPrint {
    public static int uniquePaths(int m, int n) {
        Point[] points = new Point[m+n-1];
        points[0] = new Point(0,0);
        points[points.length-1]=new Point(m-1,n-1);
        return uniquePathsRec(m-1,n-1,points,points.length-1);
    }

    private static int uniquePathsRec(int m, int n, Point[] points, int index) {
        points[index]=new Point(m,n);

        if(m==0 && n==0) {
            printPathArr(points);
            return 0;
        }

        if(m==0 ) {
            uniquePathsRec(m,n-1,points,index-1);
            return 1;
        }

        if(n==0) {
            uniquePathsRec(m-1,n,points,index-1);
            return 1;
        }

        return uniquePathsRec(m-1,n,points,index-1)+uniquePathsRec(m,n-1,points,index-1);
    }

    private static void  printPathArr(Point[] points) {
        System.out.println();
        Arrays.stream(points).forEach(point -> System.out.print(point.toString()+", "));
        System.out.println();
    }

    public static void main(String[] args) {
        int count = uniquePaths(4,4);

        System.out.println("Total No. Of Paths:" + count);
    }

}
