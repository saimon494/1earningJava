package com.udemy.tim;

import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        long avg;
        int num;
        int count = 0;

        if (!scanner.hasNextInt()) {
            System.out.println("SUM = 0 AVG = 0");
        } else {
            while (scanner.hasNextInt()) {
                num = scanner.nextInt();
                sum += num;
                count++;          }

            avg = Math.round((double) sum / count) ;
            System.out.println("SUM = " + sum +" AVG = " + avg);
        }
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
// -1, 5, 7, bg, 9 sum = 11 avg = 3
