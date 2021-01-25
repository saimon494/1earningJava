package com.udemy.tim;

public class NumberPalindrome {

    public static boolean isPalindrome(int num) {

        int reverseNum = 0;
        boolean isPalindrome = false;
        int lastDigit;

        if (num < 0) {
            num = num * -1;
            System.out.println(num);
        }

        int originalNum = num;

        while (num > 0) {
            lastDigit = num % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            num = num / 10;
        }

        if (originalNum == reverseNum) {
            return isPalindrome = true;
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-222));
    }
}
// 707