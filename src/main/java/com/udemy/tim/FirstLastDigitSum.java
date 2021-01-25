package com.udemy.tim;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int num) {

        int firstDigit = 0;
        int lastDigit = num % 10;
        int sum;

        if (num < 0) {
            return -1;
        }

        if (num / 10 < 1) {
            firstDigit = lastDigit;
        }

        while (num / 10 >= 1) {
            firstDigit = num / 10;
            num = num / 10;
        }

        sum = firstDigit + lastDigit;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(11));
    }
}
