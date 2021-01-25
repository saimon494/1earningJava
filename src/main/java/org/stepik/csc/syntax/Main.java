package org.stepik.csc.syntax;

import java.math.BigInteger;

public class Main {
    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value     any number
     * @param bitIndex  index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {
        return value ^ (1 << (bitIndex - 1));
    }
    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        if (Integer.bitCount(Math.abs(value)) == 1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        String text1 = text.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        StringBuilder sb = new StringBuilder(text1);
        return sb.reverse().toString().equals(text1);
    }
    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger num = BigInteger.ONE;
        for (int i = 1; i <= value; ++i) {
            num = num.multiply(BigInteger.valueOf(i));
        }
        return num;
    }
    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int arrLength = a1.length + a2.length;
        int[] a3 = new int[arrLength];

        int i = 0, j = 0, k = 0;
        while(i < a1.length && j < a2.length) {
            a3[k++] = a1[i] < a2[j] ? a1[i++] : a2[j++];
        }
        if(i < a1.length) {
            System.arraycopy(a1, i, a3, k, a1.length - i);
        } else if(j < a2.length) {
            System.arraycopy(a2, j, a3, k, a2.length - j);
        }
        return a3;
    }
    private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder rolesSb = new StringBuilder("");

        for (int i = 0; i < roles.length; i++) {
            rolesSb.append(roles[i] + ":" + "\n");

            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].startsWith(roles[i] + ":")) {
                    int indexOfColon = textLines[j].indexOf(":");
                    rolesSb.append(j + 1 + ")" + textLines[j].substring(indexOfColon + 1, textLines[j].length()) + "\n");
                }
            }
            rolesSb.append("\n");
        }
        return rolesSb.toString();
    }

}
