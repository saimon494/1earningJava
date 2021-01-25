package com.udemy.tim;

public class EvenDigitSum {
    public static int getEvenDigitSum(int num) {
        int lastDigit;
        int sum = 0;

        if (num < 0) {
            return -1;
        }

        while (num > 0) {
            lastDigit = num % 10;
            if (lastDigit % 2 == 0 ) {
                sum += lastDigit;
            }
            num = num / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
    }
}
