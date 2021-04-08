package com.anujaneja.algorithm.educative.binarySearch;

/**
 * Easy - 744 - https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Binary Search Pattern -
 * Edge Case - As array is circular, if target is greater than last letter or before the first letter...
 * Result would be first char of the array...
 * When doing binary search after the search is completed we need to return the ith letter start%n because
 * array is circular  e.g. if start comes to be end then we need to move to first letter...
 */
class NextLetter {

    public static char searchNextLetter(char[] letters, char target) {
        int n = letters.length;

        if (target < letters[0] || target > letters[n - 1]) {
            return letters[0];
        }

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % n];
    }

    public static void main(String[] args) {
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        System.out.println(NextLetter.searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}