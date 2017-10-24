package com.anujaneja.algorithm;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

import java.util.ArrayList;

/**
 *  * Solution: https://stackoverflow.com/questions/7086464/maximum-single-sell-profit
 * Better try to use dynamic programming.

 */
public class MaxProfitSingleBuySellActiviy {

    static class BuySellActivity {
        int buyPrice;
        int sellPrice;

        public BuySellActivity(int buyPrice,int sellPrice) {
            this.buyPrice = buyPrice;
            this.sellPrice = sellPrice;
        }

        public String toString() {
            return "( "+buyPrice+" , "+sellPrice+" )";
        }
    }
    static ArrayList<BuySellActivity> buySellActivityList = new ArrayList<BuySellActivity>();

    static void calculateMaxProfitSingleBuySell(int[] arr) {
        int max=-1;
        int min=-1;

        for(int i=0;i<arr.length;i++) {
//            System.out.println("min="+min+" max="+max);

            if(max==-1 && min==-1 ) {
                max=arr[i];
                min = arr[i];
            }

            if(arr[i]>min && arr[i]>max) {
                max=arr[i];
            }

            if(arr[i]<max){
                if(max>min) {
                    buySellActivityList.add(new BuySellActivity(min,max));
                }

                min =  arr[i];
                max = arr[i];
            }
        }

        boolean entryFound = false;

        for(BuySellActivity buySellActivity:buySellActivityList) {
            if(buySellActivity.buyPrice==min && buySellActivity.sellPrice==max) {
                entryFound = true;
            }
        }

        if(entryFound==false) {
            if(max>min) {
                buySellActivityList.add(new BuySellActivity(min,max));
            }

        }
    }

    public static void main(String[] s) {
//        int[] arr = new int[] {100, 180, 260, 310, 40, 535, 695};
//        int[] arr = new int[] {23,13,25,29,33,19,34,45,65,67};
        int[] arr = new int[] {100,99,90,85,80,75,70,65,60};
        calculateMaxProfitSingleBuySell(arr);
        System.out.println(buySellActivityList);
    }
}
