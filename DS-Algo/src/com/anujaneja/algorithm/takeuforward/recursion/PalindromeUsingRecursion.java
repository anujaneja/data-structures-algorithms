package com.anujaneja.algorithm.takeuforward.recursion;

/*
    1. Time Complexity: O(n) -> Exponential Time complexity
    2. Space Complexity: Stack space for function calls...
 */
public class PalindromeUsingRecursion {

    public static boolean isPalindrome(String name, int i, int j) {
        if (i > j) {
            return true;
        }
        if (name.charAt(i) != name.charAt(j)) {
            return false;
        }
        return isPalindrome(name, i + 1, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("Anuj", 0, "Anuj".length() - 1));
        System.out.println(isPalindrome("abba", 0, "abba".length() - 1));
    }
}
