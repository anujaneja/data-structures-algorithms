package com.anujaneja.algorithm.educative.xor;

class CalculateComplement {
    public static int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        /**
         * Number^Complement = All_bits_set
         * Number^Number^Complement = Number^All_bits_set
         * 0^Complement = Number^All_bits_set
         * Complement = Number^All_bits_set
         */

        //Count no of bits...right shift means division of number by 2
        int num = n;
        int bitCount = 0;
        while (num > 0) {
            bitCount++;
            num = num >> 1;
        }

        int all_bits_set = (int) Math.pow(2, bitCount) - 1;

        return n ^ all_bits_set;
    }

    public static void main(String args[]) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(0));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}